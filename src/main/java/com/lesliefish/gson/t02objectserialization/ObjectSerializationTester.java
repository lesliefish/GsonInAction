package com.lesliefish.gson.t02objectserialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class ObjectSerializationTester {

    public static void test() {

        ObjectSerializationTester tester = new ObjectSerializationTester();
        try {
            Student student = new Student();
            student.setAge(10);
            student.setName("leslie fish");

            tester.writeJson(student);
            Student student1 = tester.readJson();
            System.out.println(student1); // 从文件中读取字串序列化为对象
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void writeJson(Student student) throws Exception {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        FileWriter fileWriter = new FileWriter("student.json");
        fileWriter.write(gson.toJson(student));
        fileWriter.close();
    }

    private Student readJson() throws Exception {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("student.json"));

        Student student = gson.fromJson(bufferedReader, Student.class);
        return student;
    }
}

class Student {
    private String name;
    private int age;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Student [ name: " + name + ", age: " + age + " ]";
    }
}
