package com.ptg;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== UNIVERSITY COURSE REGISTRATION SYSTEM ===\n");

        Registration registration = new Registration();
        LeaveRegistration leaveReg = new LeaveRegistration();

        // === CREATE COURSES ===
        System.out.println("1. Creating courses...");
        Course math = new Course("Mathematics", "C-01", 2);      // Capacity: 2
        Course english = new Course("English", "C-02");          // Capacity: 4 (default)
        Course science = new Course("Science", "C-03", 3);       // Capacity: 3
        Postrequisite math2 = new Postrequisite("Mathematics 2", "C-08", 2, math);

        System.out.println("Total courses created: " + Course.totalCourse);

        // === CREATE STUDENTS ===
        System.out.println("\n2. Creating students...");
        Student s1 = new Student("Hilal", 19, "ID-01");
        Student s2 = new Student("Fali", 18, "ID-02");
        Student s3 = new Student("Dafi", 19, "ID-03");
        Student s4 = new Student("John", 20, "ID-04");

        // === TEST 1: NORMAL ENROLLMENT ===
        System.out.println("\n3. Testing normal enrollment...");
        registration.register(math, s1);
        System.out.println("Math enrolled: " + math.enrolled() + "/" + "2");

        registration.register(math, s2);
        System.out.println("Math enrolled: " + math.enrolled() + "/" + "2");

        // === TEST 2: COURSE CAPACITY (FULL) ===
        System.out.println("\n4. Testing course capacity (should fail)...");
        registration.register(math, s3);  // Should print "Course is full"

        // === TEST 3: PREREQUISITE (SHOULD FAIL) ===
        System.out.println("\n5. Testing prerequisite (should fail)...");
        registration.register(math2, s1);  // Hasn't finished math yet

        // === TEST 4: FINISH COURSE & RETRY PREREQUISITE ===
        System.out.println("\n6. Finishing math course...");
        registration.finish(s1, math);
        System.out.println("s1 finished math. Status: " + s1.status);

        System.out.println("\n7. Retrying prerequisite (should work)...");
        registration.register(math2, s1);  // Now should work
        System.out.println("Math2 enrolled: " + math2.enrolled() + "/2");

        // === TEST 5: DUPLICATE ENROLLMENT ===
        System.out.println("\n8. Testing duplicate enrollment...");
        registration.register(math2, s1);  // Already enrolled

        // === TEST 6: STUDENT COURSE LOAD ===
        System.out.println("\n9. Testing student course load...");
        registration.register(english, s1);
        registration.register(science, s1);
        s1.courses();  // Show s1's courses

        // === TEST 7: UNREGISTER ===
        System.out.println("\n10. Testing unregister...");
        registration.unregister(english, s1);
        System.out.println("English enrolled: " + english.enrolled() + "/4");

        // === TEST 8: GRADUATION ===
        System.out.println("\n11. Testing graduation...");
        leaveReg.graduate(s2, "Completed all requirements");
        System.out.println("s2 status: " + s2.status);
        System.out.println("Total graduated: " + LeaveRegistration.graduated);

        // === TEST 9: ENROLL AFTER GRADUATION (SHOULD FAIL) ===
        System.out.println("\n12. Testing enrollment after graduation...");
        registration.register(math, s2);  // Should fail

        // === TEST 10: DROPOUT & RE-ENROLL ===
        System.out.println("\n13. Testing dropout...");
        Student s5 = new Student("Returning", 21, "ID-05");
        registration.register(science, s5);
        leaveReg.DropOut(s5, "Financial issues");
        System.out.println("s5 status: " + s5.status);

        System.out.println("\n14. Testing re-enrollment after dropout...");
        registration.register(english, s5);  // Should work (dropped can return)

        // === TEST 11: DISPLAY COURSE INFO ===
        System.out.println("\n15. Course information:");
        math.courseInfo();
        math2.courseInfo();

        // === TEST 12: DISPLAY STUDENT INFO ===
        System.out.println("\n16. Student information:");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s5);

        System.out.println("\n=== TESTING COMPLETE ===");
        System.out.println("Total courses: " + Course.totalCourse);
        System.out.println("Total graduated: " + LeaveRegistration.graduated);
    }
}