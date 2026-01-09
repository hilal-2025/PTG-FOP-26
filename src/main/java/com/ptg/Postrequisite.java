package com.ptg;

public class Postrequisite extends Course{
    Course prerequisite;
    private static final int DEFAULT_CAPACITY = 4;
    Student[] students;

    Postrequisite(String name, String id, int MAX_CAPACITY, Course prerequisite) {
        super(name, id, MAX_CAPACITY);
        this.prerequisite = prerequisite;
        students = new Student[MAX_CAPACITY];
    }

    @Override
    void courseInfo(){
        super.courseInfo();
    }

    boolean checkFinished(Student student, Postrequisite postrequisite) {
        for(int i=0;i < student.finished.length;i++) {
            if (student.finished[i] == postrequisite.prerequisite) {
                return true;
            }
        }
        return false;
    }
}
