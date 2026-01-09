package com.ptg;

public class Registration {
    Student student;
    Course course;
    private boolean foundPlace;

    boolean doubleChecker() {
        boolean dupe = false;

        for(int i=0;i < course.Students.length;i++) {
            if(course.Students[i] == (student)) {
                dupe = true;
            }
        }
        return dupe;
    }

    boolean fullChecker(Course course) {
        for(int i=0;i < course.Students.length;i++) {
            if(course.Students[i] == null) {
                return false;
            }
        }

        return true;
    }

    boolean checkFinished(Student student, Postrequisite postrequisite) {
        for(int i=0;i < student.finished.length;i++) {
            if (student.finished[i] == postrequisite.prerequisite) {
                return true;
            }
        }
        return false;
    }

    private void add(Student student, Course course) {

        for(int i=0;i < course.Students.length;i++) {
            if(course.Students[i] == null) {
                course.Students[i] = student;
                foundPlace = true;
                break;
            }
        }

        for(int i=0;i < student.Courses.length;i++) {
            if(student.Courses[i] == null) {
                student.Courses[i] = course;
                break;
            }
        }
    }

    private void remove(Student student, Course course) {
        for(int i=0;i < course.Students.length;i++) {
            if(course.Students[i] == student) {
                course.Students[i] = null;
                break;
            }
        }

        for(int i=0;i < student.Courses.length;i++) {
            if(student.Courses[i] == course) {
                student.Courses[i] = null;
                break;
            }
        }

        student.status = "Active Student";
    }

    void register(Course course, Student student) {
        this.course = course;
        this.student = student;

        if (doubleChecker()) {
            System.out.println("This student is already enrolled in this course.");
            return;
        }

        if (fullChecker(course)) {
            System.out.println("This course is full.");
            return;
        }

        if (student.status.equals("Graduated")) {
            System.out.println("Student is already graduated.");
            return;
        }

        if (course instanceof Postrequisite) {
            if (checkFinished(student, (Postrequisite) course)){
                add(student, course);
            }else System.out.println("You need to finish " +((Postrequisite) course).prerequisite + " first.");
        }
        else add(student, course);

    }

    void unregister(Course course, Student student){
        this.course = course;
        this.student = student;

        if (!doubleChecker()) {
            System.out.println("This student is not in this course.");
            return;
        }
        remove(student, course);
    }

    void finish(Student student, Course course) {
        for(int i = 0; i < course.totalCourse; i++){
            if (student.finished[i] == null){
                student.finished[i] = course;
                remove(student, course);
                break;
            }
        }
    }

    @Override
    public String toString() {return "A registration class";}
}
