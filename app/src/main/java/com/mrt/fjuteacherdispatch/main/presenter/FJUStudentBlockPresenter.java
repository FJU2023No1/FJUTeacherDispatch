package com.mrt.fjuteacherdispatch.main.presenter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.mrt.fjuteacherdispatch.main.model.FJUStudentBlockModel;
import com.mrt.fjuteacherdispatch.main.model.data.TeacherSchedule;
import com.mrt.fjuteacherdispatch.main.view.FJUTDRegisterActivity;
import com.mrt.fjuteacherdispatch.main.view.MainTabbarActivity;
import com.mrt.fjuteacherdispatch.main.view.fragment.HomePageFragment;
import com.mrt.fjuteacherdispatch.main.view.fragment.block.FJUStudentBlockFragment;
import com.mrt.fjuteacherdispatch.main.view.listener.FJUStudentBlockListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FJUStudentBlockPresenter {

    private FJUStudentBlockFragment mFragment;

    private FJUStudentBlockModel mModel;

    private FJUStudentBlockListener mListener;

    private Context mContext;

    public FJUStudentBlockPresenter(
            FJUStudentBlockFragment mFragment,
            FJUStudentBlockModel mModel,
            FJUStudentBlockListener mListener) {
        this.mFragment = mFragment;
        this.mModel = mModel;
        this.mListener = mListener;
    }

    public void setBundle(Bundle bundle) {
        if(bundle!=null) {
            mModel.userEMail.set(bundle.getString(HomePageFragment.FIELD_USER_EMAIL));
        }
    }

    public void init() {
        this.mContext = mFragment.getActivity();
        sendRequestWithOkHttpForSearchTeacherSchedule();
    }

    public void sendRequestWithOkHttpForSearchTeacherSchedule() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    //POST
                    RequestBody requestBody = new FormBody.Builder()
                            .build();
                    Request request = new Request.Builder()
                            .url("https://lynnxick.synology.me/api/FJU/SearchTeacherSchedule.php")
                            .post(requestBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    getTeacherScheduleList(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void getTeacherScheduleList(String jsonData) {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            ArrayList<TeacherSchedule> teacherScheduleArrayList = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {
                //JSON格式改為字串
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String TSID = jsonObject.getString("TSID");
                String TSClassTime = jsonObject.getString("TSClassTime");
                String TSClassLocation = jsonObject.getString("TSClassLocation");
                String TSMoney = jsonObject.getString("TSMoney");
                String TSSubject = jsonObject.getString("TSSubject");
                String TSTeacherEmail = jsonObject.getString("TSTeacherEmail");

                teacherScheduleArrayList.add(new TeacherSchedule(Integer.parseInt(TSID), TSClassTime, TSClassLocation, Integer.parseInt(TSMoney), TSSubject, TSTeacherEmail));
            }

            mFragment.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mFragment.setRecyclerViewMessages(teacherScheduleArrayList, mModel.userEMail.get().toString());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
