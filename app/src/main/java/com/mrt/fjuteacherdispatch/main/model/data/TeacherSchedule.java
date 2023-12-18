package com.mrt.fjuteacherdispatch.main.model.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

public class TeacherSchedule implements
        Serializable {

    public int TSID;
    public String TSClassTime;

    public String TSClassLocation;

    public int TSMoney;

    public String TSSubject;

    public String TSTeacherEmail;

    public TeacherSchedule(
            int TSID,
            String TSClassTime,
            String TSClassLocation,
            int TSMoney,
            String TSSubject,
            String TSTeacherEmail
    ) {
        this.TSID = TSID;
        this.TSClassTime = TSClassTime;
        this.TSClassLocation = TSClassLocation;
        this.TSMoney = TSMoney;
        this.TSSubject = TSSubject;
        this.TSTeacherEmail = TSTeacherEmail;
    }

    public static ArrayList<TeacherSchedule> getArrayList(Object data) {
        ArrayList<TeacherSchedule> rc = new ArrayList<>();
        //
        Gson gson = new Gson();
        Type collectionType = new TypeToken<Collection<TeacherSchedule>>(){}.getType();
        Collection<TeacherSchedule> collectioObj = gson.fromJson(gson.toJson(data), collectionType);
        //
        rc.addAll(collectioObj);
        if(!rc.isEmpty()){

        }
        //
        return rc;
    }
}