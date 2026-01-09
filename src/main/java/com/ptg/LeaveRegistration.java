package com.ptg;

public class LeaveRegistration extends Registration {

    private String Reason;
    private String DEFAULT_REASON = "Do not want to tell";
    static int graduated;


    void leave(Student student) {

        for (int i = 0; i < student.Courses.length; i++) {
            if(student.Courses[i] != null){
                Course course = student.Courses[i];
                student.Courses[i] = null;
                for(int x=0;x<course.Students.length;x++){
                    if(course.Students[x] == student){
                        course.Students[x] = null;
                    }
                }
            }
        }
    }

    void graduate(Student student) {
        leave(student);
        student.status = "Graduated";
        graduated++;
        Reason = DEFAULT_REASON;
    }

    void graduate(Student student, String reason) {
        leave(student);
        student.status = "Graduated";
        graduated++;
        Reason = reason;
    }

    void DropOut(Student student) {
        leave(student);
        student.status = "Dropped";
        Reason = DEFAULT_REASON;
    }

    void DropOut(Student student, String reason) {
        leave(student);
        student.status = "Dropped";
        Reason = reason;
    }
}
