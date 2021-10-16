package com.globant.javaBasics.runner;

import com.globant.javaBasics.data.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Runner {
    public static void main(String[] args) {
        int option;
        int option2;
        boolean exit = true;
        Scanner scan;

        University myUniversity = initializeUniversity();

        while (exit == true) {
            System.out.println("-------------------------------------------------------\n¡Welcome to your University tracker! Type a number to:\n 1. Print all the teachers. \n 2. Print all groups. \n 3. Create a new student and add it to a group. \n 4. Create a new group with its data. \n 5. Search classes by a student. \n 6. Exit. \n -----------------------------------------------------  ");
            scan = new Scanner(System.in);
            option = scan.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Here is the list with teachers that the university has\n");
                    printTeachers(myUniversity.getTeachersList());
                    break;

                case 2:
                    System.out.println("Here are the names of the groups that the university has. Type the number of the group that you want to learn more about.");
                    printGroupsNames(myUniversity.getGroupsList());
                    scan = new Scanner(System.in);
                    option2 = scan.nextInt();

                    printGroupInfo(myUniversity.getGroupsList().get(option2 - 1));
                    break;
                case 3:
                    System.out.print("Type the name of the new student: ");
                    scan = new Scanner(System.in);
                    String newStudentName = scan.nextLine();
                    System.out.print("Type the age of the new student: ");
                    scan = new Scanner(System.in);
                    int newStudentAge = scan.nextInt();
                    System.out.println("Type the number of the group where you want to add the new student: ");
                    printGroupsNames(myUniversity.getGroupsList());
                    scan = new Scanner(System.in);
                    int index = scan.nextInt() - 1;

                    Student newStudent = new Student(newStudentName, newStudentAge);
                    myUniversity.addNewStudentToStudentsList(newStudent);
                    myUniversity.addNewStudentToGroup(newStudent, index);
                    System.out.println("Here is the list of students of the group " + myUniversity.getGroupsList().get(index).getGroupName() + " updated.\nBTW, the new students is added to the whole university students list ;).");
                    printStudentsNames(myUniversity.getGroupsList().get(index).getGroupStudentsList());
                    break;
                case 4:
                    System.out.print("Type the name of the new group: ");
                    scan = new Scanner(System.in);
                    String newGroupName = scan.nextLine();
                    System.out.print("Type the classroom number of the new group: ");
                    scan = new Scanner(System.in);
                    int newGroupClassroom = scan.nextInt();

                    System.out.println("Select what kind of contract will have the new teacher: \n 1. Full time. \n 2. Part time.");
                    scan = new Scanner(System.in);
                    int newTeacherContract = scan.nextInt();
                    System.out.print("Type the name of the new teacher: ");
                    scan = new Scanner(System.in);
                    String newTeacherName = scan.nextLine();
                    System.out.print("Type the base salary of the new teacher: ");
                    scan = new Scanner(System.in);
                    float newTeacherBaseSalary = scan.nextFloat();

                    Teacher newTeacher = new FullTimeTeacher(newTeacherName, newTeacherBaseSalary, 0);
                    if (newTeacherContract == 1) {
                        System.out.print("Type the experience years of the new teacher: ");
                        scan = new Scanner(System.in);
                        int newTeacherExpYears = scan.nextInt();
                        newTeacher = new FullTimeTeacher(newTeacherName, newTeacherBaseSalary, newTeacherExpYears);
                    } else if (newTeacherContract == 2) {
                        System.out.print("Type the hours per week that will work the new teacher: ");
                        scan = new Scanner(System.in);
                        int newTeacherHoursWeek = scan.nextInt();
                        newTeacher = new PartTimeTeacher(newTeacherName, newTeacherBaseSalary, newTeacherHoursWeek);
                    } else {
                        System.out.println("That option is not valid.");
                    }

                    System.out.print("Type the number of students that you want to add to the new group: ");
                    scan = new Scanner(System.in);
                    int numberNewStudents = scan.nextInt();

                    List<Student> newGroupStudentsList = new ArrayList<>();

                    myUniversity.getGroupsList().add(new Group(newGroupName, newGroupClassroom, newGroupStudentsList, newTeacher));
                    myUniversity.getTeachersList().add(newTeacher);

                    for (int i = 0; i < numberNewStudents; i++) {
                        System.out.print("Type the name of the new student: ");
                        scan = new Scanner(System.in);
                        String newStudentName2 = scan.nextLine();
                        System.out.print("Type the age of the new student: ");
                        scan = new Scanner(System.in);
                        int newStudentAge2 = scan.nextInt();
                        myUniversity.getGroupsList().get(myUniversity.findIndexOfLastGroupOfGroupsList(myUniversity.getGroupsList())).addNewStudentTogroupStudentsList(new Student(newStudentName2, newStudentAge2));
                        myUniversity.addNewStudentToStudentsList(new Student(newStudentName2, newStudentAge2));
                    }

                    System.out.println("Your new group is created. Find all the info about it below:");
                    printGroupInfo(myUniversity.getGroupsList().get(myUniversity.findIndexOfLastGroupOfGroupsList(myUniversity.getGroupsList())));

                    break;
                case 5:
                    System.out.println("Here is the list of all the students that the university has, type the Id of the student that you want to look for:");
                    printStudentsNames(myUniversity.getStudentsList());
                    scan = new Scanner(System.in);
                    int  idOfStudentToFind = scan.nextInt();

                    System.out.println("\nThat student is inscribed in these groups:");
                    printGroupsNames(myUniversity.filterGroups(idOfStudentToFind,myUniversity.getGroupsList()));

                    break;
                case 6:
                    System.out.println("Hope you return soon!");
                    exit = false;
                    break;
                default:
                    System.out.println("That option is not valid, type another number.");
                    break;
            }
        }
    }

    public static University initializeUniversity() {
        University myUniversity = new University();

        myUniversity.addNewTeacherToTeachersList(new FullTimeTeacher("Juan", 200, 3));
        myUniversity.addNewTeacherToTeachersList(new PartTimeTeacher("María", 200, 48));
        myUniversity.addNewTeacherToTeachersList(new FullTimeTeacher("Pedro", 200, 5));
        myUniversity.addNewTeacherToTeachersList(new PartTimeTeacher("Elena", 200, 20));

        Student student1 = new Student("Natalia", 23);
        Student student2 = new Student("Santiago", 25);
        Student student3 = new Student("Camilo", 21);
        Student student4 = new Student("Jose", 24);
        Student student5 = new Student("Manuela", 23);
        Student student6 = new Student("Laura", 22);

        myUniversity.addNewStudentToStudentsList(student1);
        myUniversity.addNewStudentToStudentsList(student2);
        myUniversity.addNewStudentToStudentsList(student3);
        myUniversity.addNewStudentToStudentsList(student4);
        myUniversity.addNewStudentToStudentsList(student5);
        myUniversity.addNewStudentToStudentsList(student6);

        List<Student> list1 = new ArrayList<>();
        list1.add(student1);
        list1.add(student2);
        list1.add(student3);
        List<Student> list2 = new ArrayList<>();
        list2.add(student2);
        list2.add(student3);
        list2.add(student4);
        List<Student> list3 = new ArrayList<>();
        list3.add(student3);
        list3.add(student4);
        list3.add(student5);
        List<Student> list4 = new ArrayList<>();
        list4.add(student4);
        list4.add(student5);
        list4.add(student6);

        myUniversity.addNewGroupToGroupsList(new Group("Math", 101, list1, myUniversity.getTeachersList().get(0)));
        myUniversity.addNewGroupToGroupsList(new Group("Science", 102, list2, myUniversity.getTeachersList().get(1)));
        myUniversity.addNewGroupToGroupsList(new Group("Philosophy", 201, list3, myUniversity.getTeachersList().get(2)));
        myUniversity.addNewGroupToGroupsList(new Group("Chemistry", 202, list4, myUniversity.getTeachersList().get(3)));

        return myUniversity;
    }

    public static void printTeachers(ArrayList<Teacher> teachersList) {
        System.out.println("------------------TEACHERS LIST----------------");
        for (Teacher i : teachersList) {
            System.out.println(i);
        }
        System.out.println("-------------END OF THE TEACHERS LIST----------------\n");
    }

    public static void printGroupsNames(ArrayList<Group> groupsList) {
        for (int i = 0; i < groupsList.size(); i++) {
            System.out.println((i + 1) + ". " + groupsList.get(i).getGroupName() + " group.");
        }
    }

    public static void printStudentsNames(List<Student> studentsList) {
        for (int i = 0; i < studentsList.size(); i++) {
            System.out.println((i+1) + "."+ studentsList.get(i));
        }
    }

    public static void printGroupInfo(Group group) {
        System.out.println(group);
        System.out.println("Students:");
        printStudentsNames(group.getGroupStudentsList());
        System.out.println("--------------------------------------------\n");
    }
}
