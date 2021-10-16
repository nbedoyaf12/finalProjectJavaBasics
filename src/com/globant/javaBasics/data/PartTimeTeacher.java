package com.globant.javaBasics.data;

public class PartTimeTeacher extends Teacher {
    private int hoursWeek;

    public PartTimeTeacher(String teacherName, float baseSalary,int hoursWeek) {
        super(teacherName,baseSalary);
        this.hoursWeek = hoursWeek;
    }

    public double getSalary(){
        return super.baseSalary*this.hoursWeek;
    }

    public String toString(){
        return "Name: " + super.getTeacherName() + "." + " Base Salary: " + super.getBaseSalary()+"." + " Complete Salary: "+ getSalary()+ ". Hours per week: " + this.hoursWeek+ ".";
    }
}
