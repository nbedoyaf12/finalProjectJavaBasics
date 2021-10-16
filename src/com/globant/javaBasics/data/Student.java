package com.globant.javaBasics.data;

public class Student {
    private String studentName;
    private int id;
    private static int nextId=100;
    private int age;

    public Student(String studentName, int age) {
        this.studentName = studentName;
        this.age = age;
        this.id= nextId++;
    }

    public int getId(){
        return this.id;
    }

    public String toString(){
        return " Student name: " + this.studentName+ ". Age: " +this.age+". Id: "+getId()+".";
    }
}
