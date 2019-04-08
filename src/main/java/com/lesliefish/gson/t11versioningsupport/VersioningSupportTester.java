package com.lesliefish.gson.t11versioningsupport;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Since;

public class VersioningSupportTester {
    public static void test() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setVersion(1.0);
        Gson gson = gsonBuilder.create();

        Student student = new Student();
        student.setRollNo(11);
        student.setName("leslie fish");
        student.setVerified(true);

        String jsonString = gson.toJson(student);
        System.out.println(jsonString);

        gson = new Gson();
        jsonString = gson.toJson(student);
        System.out.println(jsonString);
    }
}

class Student {
    @Since(1.0)
    private int rollNo;

    @Since(1.0)
    private String name;

    @Since(1.1)
    private boolean verified;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public boolean isVerified() {
        return verified;
    }
}