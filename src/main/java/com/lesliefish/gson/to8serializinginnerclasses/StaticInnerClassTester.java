package com.lesliefish.gson.to8serializinginnerclasses;

import com.google.gson.Gson;

public class StaticInnerClassTester {
    public static void test() {
        System.out.println("static inner class test begin: ");
        MyStudent student = new MyStudent();
        student.setRollNo(1);
        MyStudent.Name name = new MyStudent.Name();

        name.firstName = "leslie";
        name.lastName = "fish";
        student.setName(name);

        Gson gson = new Gson();
        String jsonString = gson.toJson(student);
        System.out.println(jsonString);
        student = gson.fromJson(jsonString, MyStudent.class);

        System.out.println("Roll No: " + student.getRollNo());
        System.out.println("First Name: " + student.getName().firstName);
        System.out.println("Last Name: " + student.getName().lastName);
        String nameString = gson.toJson(name);
        System.out.println(nameString);

        name = gson.fromJson(nameString, MyStudent.Name.class);
        System.out.println(name.getClass());
        System.out.println("First Name: " + name.firstName);
        System.out.println("Last Name: " + name.lastName);
    }
}

class MyStudent {
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

    static class Name {
        public String firstName;
        public String lastName;
    }
}
