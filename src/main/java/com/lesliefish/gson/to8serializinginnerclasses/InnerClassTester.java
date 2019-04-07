package com.lesliefish.gson.to8serializinginnerclasses;

import com.google.gson.Gson;

public class InnerClassTester {

    public static void test() {
        Student student = new Student();
        student.setRollNo(11);

        Student.Name name = student.new Name();
        name.firstName = "leslie";
        name.lastName = "fish";
        student.setName(name);

        // 序列化
        Gson gson = new Gson();
        String jsonString = gson.toJson(student);
        System.out.println(jsonString);

        student = gson.fromJson(jsonString, Student.class);

        System.out.println("Roll No: " + student.getRollNo());
        System.out.println("First Name: " + student.getName().firstName);
        System.out.println("Last Name: " + student.getName().lastName);

        String nameString = gson.toJson(student.getName());
        System.out.println(nameString);

        name = gson.fromJson(nameString, Student.Name.class);
        System.out.println(name.getClass());
        System.out.println("First Name: " + name.firstName);
        System.out.println("Last Name: " + name.lastName);
    }
}

class Student {
    private int rollNo;
    private Name name;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    class Name {
        public String firstName;
        public String lastName;
    }
}