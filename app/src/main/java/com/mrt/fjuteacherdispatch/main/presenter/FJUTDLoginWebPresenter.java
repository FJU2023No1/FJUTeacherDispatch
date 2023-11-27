package com.mrt.fjuteacherdispatch.main.presenter;

import com.mrt.fjuteacherdispatch.main.model.FJUTDLoginWebModel;
import com.mrt.fjuteacherdispatch.main.view.FJUTDLoginWebActivity;
import com.mrt.fjuteacherdispatch.main.view.FJUTDRegisterActivity;
import com.mrt.fjuteacherdispatch.main.view.MainTabbarActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FJUTDLoginWebPresenter {

    private FJUTDLoginWebActivity mActivity;

    private FJUTDLoginWebModel mModel;

    public FJUTDLoginWebPresenter (
            FJUTDLoginWebActivity mActivity,
            FJUTDLoginWebModel mModel) {
        this.mActivity = mActivity;
        this.mModel = mModel;
    }

    public void init() {
    }

    public void onGoToLogin() {
        sendRequestWithOkHttpForUserList();
    }

    private void sendRequestWithOkHttpForUserList() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    OkHttpClient client = new OkHttpClient();
                    //POST
                    RequestBody requestBody = new FormBody.Builder()
                            .add("FJUTDUserMail", mModel.userMail.get().toString())
                            .add("FJUTDUserPassword", mModel.userPassword.get().toString())
                            .build();
                    Request request = new Request.Builder()
                            .url("https://lynnxick.synology.me/api/FJU/SearchFJUUser.php")
                            .post(requestBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    checkUserList(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void checkUserList(String jsonData) {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);

            for (int i = 0; i < jsonArray.length(); i++) {
                //JSON格式改為字串
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String userCount = jsonObject.getString("UserCount");

                if (userCount.equals("1")) {
                    MainTabbarActivity.startActivity(mActivity, true);
                } else {
                    FJUTDRegisterActivity.startActivity(mActivity, false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
