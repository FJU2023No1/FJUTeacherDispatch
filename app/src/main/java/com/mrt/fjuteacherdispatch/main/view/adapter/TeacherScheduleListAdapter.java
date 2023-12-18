package com.mrt.fjuteacherdispatch.main.view.adapter;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.mrt.fjuteacherdispatch.R;
import com.mrt.fjuteacherdispatch.databinding.FjuTdAdapterTeacherScheduleItemBinding;
import com.mrt.fjuteacherdispatch.main.model.data.TeacherSchedule;
import com.mrt.fjuteacherdispatch.main.presenter.FJUStudentBlockPresenter;

import java.util.ArrayList;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TeacherScheduleListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private FragmentActivity mActivity;

    private FJUStudentBlockPresenter mPresenter;

    private ArrayList<TeacherSchedule> scheduleList;

    private String userMail;

    /**
     * 常用商品.
     * @param mActivity
     * @param scheduleList
     */
    public TeacherScheduleListAdapter(
            FragmentActivity mActivity,
            FJUStudentBlockPresenter mPresenter,
            ArrayList<TeacherSchedule> scheduleList,
            String userMail
    ) {
        this.mActivity = mActivity;
        this.mPresenter = mPresenter;
        this.scheduleList = scheduleList;
        this.userMail = userMail;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        FjuTdAdapterTeacherScheduleItemBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(mActivity), R.layout.fju_td_adapter_teacher_schedule_item, viewGroup, false);
        return new TeacherScheduleListAdapter.ViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return scheduleList.size();
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TeacherScheduleListAdapter.ViewHolder mHolder = (TeacherScheduleListAdapter.ViewHolder) holder;

        mHolder.binding.classDateTime.setText(scheduleList.get(position).TSClassTime);
        mHolder.binding.classSubject.setText(scheduleList.get(position).TSSubject);
        mHolder.binding.classLocation.setText(scheduleList.get(position).TSClassLocation);
        mHolder.binding.classMoney.setText(String.valueOf(scheduleList.get(position).TSMoney));
        mHolder.binding.teacherMail.setText(scheduleList.get(position).TSTeacherEmail);

        mHolder.binding.determine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendRequestWithOkHttpForReserveTeacherSchedule(scheduleList.get(position).TSID);
                mPresenter.sendRequestWithOkHttpForSearchTeacherSchedule();
            }
        });
    }

    private void sendRequestWithOkHttpForReserveTeacherSchedule(int TSID) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    //POST
                    RequestBody requestBody = new FormBody.Builder()
                            .add("StudentID", userMail)
                            .add("TSID", String.valueOf(TSID))
                            .build();
                    Request request = new Request.Builder()
                            .url("https://lynnxick.synology.me/api/FJU/ReserveTeacherSchedule.php")
                            .post(requestBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        FjuTdAdapterTeacherScheduleItemBinding binding;

        ViewHolder(FjuTdAdapterTeacherScheduleItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}