package com.ptg;

public class Student {
    private String name;
    private int age;
    private String id;

    String status = "Not a student";

    private static final int DEFAULT_AGE = 18;
    private static final String DEFAULT_ID = "ID-00";
    private static final int MAX_COURSE = 5;

    Course[] Courses = new Course[MAX_COURSE];
    Course[] finished;

    Student() {
        this("Unknown");
    }

    Student(String name) {
        this(name, DEFAULT_AGE);
    }

    Student(String name, int age) {
        this(name, age, DEFAULT_ID);
    }

    Student(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
        finished = new Course[Course.totalCourse];
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", id=" + id + "]";
    }

    void setAge(int age) {
        this.age = age;
    }

    void setId(String id) {
        this.id = id;
    }

    void setName(String name) {
        this.name = name;
    }

    void courses(){
        System.out.println("Course Enrolled: ");
        for(int i = 0; i < MAX_COURSE; i++){
            if (Courses[i] != null){
                System.out.println(Courses[i]);
            }
        }
    }
}
