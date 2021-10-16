package com.globant.javaBasics.data;

import java.util.ArrayList;
import java.util.List;

public class University {
    private ArrayList<Teacher> teachersList;
    private List<Student> studentsList;
    private ArrayList<Group> groupsList;

    public University() {
        this.teachersList = new ArrayList<>();
        this.studentsList = new ArrayList<>();
        this.groupsList = new ArrayList<>();
    }

    public ArrayList<Teacher> getTeachersList() {
        return teachersList;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public ArrayList<Group> getGroupsList() {
        return groupsList;
    }

    public void addNewTeacherToTeachersList(Teacher teacher) {
        this.teachersList.add(teacher);
    }

    public void addNewStudentToStudentsList(Student student) {
        this.studentsList.add(student);
    }

    public void addNewGroupToGroupsList(Group group) {
        this.groupsList.add(group);
    }

    public void addNewStudentToGroup(Student student, int index) {
        this.groupsList.get(index).addNewStudentTogroupStudentsList(student);
    }

    public int findIndexOfLastGroupOfGroupsList(ArrayList<Group> groupsList) {
        return groupsList.indexOf(groupsList.get(groupsList.size() - 1));
    }

    public ArrayList<Group> filterGroups(int studentId,ArrayList<Group> groupsList ){
        ArrayList<Group> groupListFiltered= new ArrayList<>();
        for(int i=0; i<groupsList.size();i++){
            for(int s=0; s<groupsList.get(i).getGroupStudentsList().size();s++){
                if(groupsList.get(i).getGroupStudentsList().get(s).getId()== studentId){
                    groupListFiltered.add(groupsList.get(i));
                }
            }
        }
        return groupListFiltered;
    }
}
