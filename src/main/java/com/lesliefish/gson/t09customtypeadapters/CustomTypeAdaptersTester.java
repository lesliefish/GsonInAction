package com.lesliefish.gson.t09customtypeadapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class CustomTypeAdaptersTester {
    public static void test() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Student.class, new StudentAdpter());
        gsonBuilder.setPrettyPrinting();

        Gson gson = gsonBuilder.create();

        String jsonString = "{\"name\":\"leslie\", \"rollNo\":1}";

        Student student = gson.fromJson(jsonString, Student.class);
        System.out.println(student);

        jsonString = gson.toJson(student);
        System.out.println(student);
    }
}


// 自定义适配器
class StudentAdpter extends TypeAdapter<Student> {
    public void write(JsonWriter jsonWriter, Student student) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("name");
        jsonWriter.value(student.getName());
        jsonWriter.name("rollNo");
        jsonWriter.value(student.getRollNo());
        jsonWriter.endObject();
    }

    public Student read(JsonReader jsonReader) throws IOException {
        Student student = new Student();
        jsonReader.beginObject();

        String fieldname = null;
        while (jsonReader.hasNext()) {
            JsonToken token = jsonReader.peek();

            if (token.equals(JsonToken.NAME)) ;
            fieldname = jsonReader.nextName();

            if ("name".equals(fieldname)) {
                token = jsonReader.peek();
                student.setName(jsonReader.nextString());
            }

            if ("rollNo".equals(fieldname)) {
                token = jsonReader.peek();
                student.setRollNo(jsonReader.nextInt());
            }
        }

        jsonReader.endObject();
        return student;
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
