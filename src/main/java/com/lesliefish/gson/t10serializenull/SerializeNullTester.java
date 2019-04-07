package com.lesliefish.gson.t10serializenull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SerializeNullTester {

    public static void test() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();//序列化空值
        gsonBuilder.setPrettyPrinting();

        Gson gson = gsonBuilder.create();

        Student student = new Student();
        student.setRollNo(11);

        String jsonString = gson.toJson(student);

        System.out.println(jsonString);
        student = gson.fromJson(jsonString, Student.class);
        System.out.println(student);
    }

}

class Student {
    private int rollNo;
    private String name;

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

    public String toString() {
        return "Student[ name = " + name + ", roll no: " + rollNo + "]";
    }
}