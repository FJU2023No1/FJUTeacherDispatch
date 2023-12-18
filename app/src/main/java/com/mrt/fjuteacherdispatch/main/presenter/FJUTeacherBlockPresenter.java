package com.mrt.fjuteacherdispatch.main.presenter;

import android.content.Context;
import android.os.Bundle;

import com.mrt.fjuteacherdispatch.main.model.FJUTeacherBlockModel;
import com.mrt.fjuteacherdispatch.main.model.data.StudentDemand;
import com.mrt.fjuteacherdispatch.main.model.data.TeacherSchedule;
import com.mrt.fjuteacherdispatch.main.view.fragment.HomePageFragment;
import com.mrt.fjuteacherdispatch.main.view.fragment.block.FJUTeacherBlockFragment;
import com.mrt.fjuteacherdispatch.main.view.listener.FJUTeacherBlockListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FJUTeacherBlockPresenter {

    private FJUTeacherBlockFragment mFragment;

    private FJUTeacherBlockModel mModel;

    private FJUTeacherBlockListener mListener;

    private Context mContext;

    public FJUTeacherBlockPresenter(
            FJUTeacherBlockFragment mFragment,
            FJUTeacherBlockModel mModel,
            FJUTeacherBlockListener mListener) {
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
        sendRequestWithOkHttpForSearchStudentDemand();
    }

    public void sendRequestWithOkHttpForSearchStudentDemand() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    //POST
                    RequestBody requestBody = new FormBody.Builder()
                            .build();
                    Request request = new Request.Builder()
                            .url("https://lynnxick.synology.me/api/FJU/SearchStudentDemand.php")
                            .post(requestBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    getStudentDemandList(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void getStudentDemandList(String jsonData) {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            ArrayList<StudentDemand> StudentDemandArrayList = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {
                //JSON格式改為字串
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String SDID = jsonObject.getString("SDID");
                String SDClassTime = jsonObject.getString("SDClassTime");
                String SDClassLocation = jsonObject.getString("SDClassLocation");
                String SDContact = jsonObject.getString("SDContact");
                String SDSubject = jsonObject.getString("SDSubject");
                String SDDegree = jsonObject.getString("SDDegree");
                String SDStudentEmail = jsonObject.getString("SDStudentEmail");

                StudentDemandArrayList.add(new StudentDemand(Integer.parseInt(SDID), SDClassTime, SDClassLocation, SDContact, SDSubject, SDDegree, SDStudentEmail));
            }

            mFragment.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mFragment.setRecyclerViewMessages(StudentDemandArrayList, mModel.userEMail.get().toString());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}