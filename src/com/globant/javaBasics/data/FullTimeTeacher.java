package com.globant.javaBasics.data;

public class FullTimeTeacher extends Teacher {
    private float experienceYears;

    public FullTimeTeacher(String teacherName, float baseSalary,float experienceYears) {
        super(teacherName, baseSalary);
        this.experienceYears = experienceYears;
    }

    public double getSalary(){
        return super.baseSalary*(1.1*this.experienceYears);
    }

    public String toString(){
        return "Name: " + super.getTeacherName() + "." + " Base Salary: " + super.getBaseSalary()+"." + " Complete Salary: "+ getSalary()+ ". Years of experience: " + this.experienceYears+ ".";
    }
}
