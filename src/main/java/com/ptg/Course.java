package com.ptg;

public class Course {

    String name;
    String id;

    private static final int DEFAULT_CAPACITY = 4;
    private int  MAX_CAPACITY;
    Student[] Students;
    static int totalCourse = 0;

    Course(String name, String id){
        this.name = name;
        this.id = id;
        MAX_CAPACITY = DEFAULT_CAPACITY;
        this.Students = new Student[MAX_CAPACITY];
        totalCourse++;
    }

    Course(String name, String id, int MAX_CAPACITY) {
        this.name = name;
        this.id = id;
        this.MAX_CAPACITY = MAX_CAPACITY;
        this.Students = new Student[MAX_CAPACITY];
        totalCourse++;
    }

    @Override
    public String toString() {
        return "Course [name=" + name + ", id=" + id + "]";
    }

    void courseInfo(){
        System.out.println("Course Name: " + this.name);
        System.out.println("Course ID: " + this.id);
        System.out.println("Student Enrolled: " + enrolled() + "/" + MAX_CAPACITY);
    }

    int enrolled(){
        int enrolledStudent=0;

        for(int i = 0; i < MAX_CAPACITY; i++){
            if (Students[i] != null){
                enrolledStudent++;
            }
        }
        return enrolledStudent;
    }


    void students(){
        System.out.println("Student Enrolled: ");
        for(int i = 0; i < MAX_CAPACITY; i++){
            if (Students[i] != null){
                System.out.println(Students[i]);
            }
        }
    }

}
