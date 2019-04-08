package com.lesliefish.gson.t12excludefields;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

public class ExposeAnnotationTester {
    public static void test() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = gsonBuilder.create();

        StudentTester student = new StudentTester();
        student.setRollNo(1);
        student.setName("leslie fish");
        student.setVerified(true);
        student.setId(1);
        student.className = "VI";

        String jsonString = gson.toJson(student);
        System.out.println(jsonString);
    }
}


class StudentTester {
    @Expose
    private int rollNo;

    @Expose
    private String name;
    private boolean verified;
    private int id;
    public static String className;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}