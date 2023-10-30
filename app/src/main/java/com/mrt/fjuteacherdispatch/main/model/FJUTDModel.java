package com.mrt.fjuteacherdispatch.main.model;

import androidx.databinding.ObservableField;

import java.util.ArrayList;
import java.util.Map;

public class FJUTDModel {

    /**
     * 身份.
     * 學生，老師，管理者.
     */
    public final ObservableField<String> userIdentityText = new ObservableField<>();

    private ArrayList<Map.Entry<String,String>> userIdentityArray;

    public ArrayList<Map.Entry<String, String>> getUserIdentityArray() {
        return userIdentityArray;
    }

    public void setUserIdentityArray(ArrayList<Map.Entry<String, String>> userIdentityArray) {
        this.userIdentityArray = userIdentityArray;
    }

}
