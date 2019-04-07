package com.lesliefish.gson.t07serializationexamples;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class GenericsTester {
    public static void test() {
        // create a shape class of type circle.
        Shape<Circle> shape = new Shape<Circle>();
        Circle circle = new Circle(5.0);
        shape.setShape(circle);

        Gson gson = new Gson();
        Type shapeType = new TypeToken<Shape<Circle>>() {}.getType();

        String jsonString = gson.toJson(shape, shapeType);
        System.out.println(jsonString);

        Shape shape1 = gson.fromJson(jsonString, Shape.class);
        System.out.println(shape1.get().getClass());
        System.out.println(shape1.get().toString());
        System.out.println(shape1.getArea());

        Shape shape2 = gson.fromJson(jsonString, shapeType);
        System.out.println(shape2.get().getClass());
        System.out.println(shape2.get().toString());
        System.out.println(shape2.getArea());
    }
}

class Shape<T> {
    public T shape;

    public void setShape(T shape) {
        this.shape = shape;
    }

    public T get() {
        return shape;
    }

    public double getArea() {
        if (shape instanceof Circle) {
            return ((Circle) shape).getArea();
        }
        return 0.0;
    }
}

class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public String toString() {
        return "Circle";
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return (radius * radius * 3.14);
    }
}
