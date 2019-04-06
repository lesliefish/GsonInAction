package com.lesliefish.gson.t04objectdatabinding;

import com.google.gson.Gson;

public class ObjectDataBindingTester {

    public static void test() {
        Gson gson = new Gson();
        Student student = new Student();
        student.setAge(19);
        student.setName("lesliefish");

        System.out.println(gson.toJson(student));
        System.out.println(gson.fromJson(gson.toJson(student), Student.class));
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
