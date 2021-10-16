package com.globant.javaBasics.data;

public abstract class Teacher {
    protected String teacherName;
    protected float baseSalary;

    public Teacher(String teacherName, float baseSalary) {
        this.teacherName = teacherName;
        this.baseSalary = baseSalary;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public float getBaseSalary() {
        return baseSalary;
    }

    public abstract double getSalary();
}
