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
import com.mrt.fjuteacherdispatch.databinding.FjuTdAdapterStudentDemandItemBinding;
import com.mrt.fjuteacherdispatch.main.model.data.StudentDemand;
import com.mrt.fjuteacherdispatch.main.presenter.FJUTeacherBlockPresenter;

import java.util.ArrayList;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class StudentDemandListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private FragmentActivity mActivity;

    private FJUTeacherBlockPresenter mPresenter;

    private ArrayList<StudentDemand> demandList;

    private String userMail;

    /**
     * @param mActivity
     * @param demandList
     */
    public StudentDemandListAdapter(
            FragmentActivity mActivity,
            FJUTeacherBlockPresenter mPresenter,
            ArrayList<StudentDemand> demandList,
            String userMail
    ) {
        this.mActivity = mActivity;
        this.mPresenter = mPresenter;
        this.demandList = demandList;
        this.userMail = userMail;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        FjuTdAdapterStudentDemandItemBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(mActivity), R.layout.fju_td_adapter_student_demand_item, viewGroup, false);
        return new StudentDemandListAdapter.ViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return demandList.size();
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        StudentDemandListAdapter.ViewHolder mHolder = (StudentDemandListAdapter.ViewHolder) holder;

        mHolder.binding.classDateTime.setText(demandList.get(position).SDClassTime);
        mHolder.binding.classSubject.setText(demandList.get(position).SDSubject);
        mHolder.binding.classLocation.setText(demandList.get(position).SDClassLocation);
        mHolder.binding.classDegree.setText(String.valueOf(demandList.get(position).SDDegree));
        mHolder.binding.studentPhone.setText(demandList.get(position).SDContact);
        mHolder.binding.studentMail.setText(demandList.get(position).SDStudentEmail);

        mHolder.binding.determine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendRequestWithOkHttpForOfferStudentDemand(demandList.get(position).SDID);
                mPresenter.sendRequestWithOkHttpForSearchStudentDemand();
            }
        });
    }

    private void sendRequestWithOkHttpForOfferStudentDemand(int SDID) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.e("TEST", String.valueOf(SDID) + "_" + userMail);
                try {
                    OkHttpClient client = new OkHttpClient();
                    //POST
                    RequestBody requestBody = new FormBody.Builder()
                            .add("TeacherID", userMail)
                            .add("SDID", String.valueOf(SDID))
                            .build();
                    Request request = new Request.Builder()
                            .url("https://lynnxick.synology.me/api/FJU/OfferStudentDemand.php")
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
        FjuTdAdapterStudentDemandItemBinding binding;

        ViewHolder(FjuTdAdapterStudentDemandItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}