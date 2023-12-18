package com.mrt.fjuteacherdispatch.main.model.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

public class StudentDemand implements
        Serializable {

    public int SDID ;

    public String SDClassTime;

    public String SDClassLocation;

    public String SDContact;

    public String SDSubject;

    public String SDDegree;

    public String SDStudentEmail;

    public StudentDemand(
            int SDID ,
            String SDClassTime,
            String SDClassLocation,
            String SDContact,
            String SDSubject,
            String SDDegree,
            String SDStudentEmail
    ) {
        this.SDID  = SDID ;
        this.SDClassTime = SDClassTime;
        this.SDClassLocation = SDClassLocation;
        this.SDContact = SDContact;
        this.SDSubject = SDSubject;
        this.SDDegree = SDDegree;
        this.SDStudentEmail = SDStudentEmail;
    }

    public static ArrayList<StudentDemand> getArrayList(Object data) {
        ArrayList<StudentDemand> rc = new ArrayList<>();
        //
        Gson gson = new Gson();
        Type collectionType = new TypeToken<Collection<StudentDemand>>(){}.getType();
        Collection<StudentDemand> collectioObj = gson.fromJson(gson.toJson(data), collectionType);
        //
        rc.addAll(collectioObj);
        if(!rc.isEmpty()){

        }
        //
        return rc;
    }
}