package com.globant.javaBasics.data;

import java.util.List;

public class Group {
    private String groupName;
    private int classroomNumber;
    private List<Student> groupStudentsList;
    private Teacher teacher;

    public Group(String groupName, int classroomNumber, List<Student> studentsList, Teacher teacher) {
        this.groupName = groupName;
        this.classroomNumber = classroomNumber;
        this.groupStudentsList = studentsList;
        this.teacher = teacher;
    }

    public List<Student> getGroupStudentsList() {
        return groupStudentsList;
    }

    public String getGroupName() {
        return groupName;
    }

    public void addNewStudentTogroupStudentsList(Student student){
        this.groupStudentsList.add(student);
    }

    public String toString(){
        return "-----------------" + this.groupName + "-----------------\n"+ "Classroom Number: " + this.classroomNumber +"\n"+ "Group Teacher: " + this.teacher.getTeacherName();
    }
   }
