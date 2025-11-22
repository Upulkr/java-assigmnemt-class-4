package com.stemlink.tutor;

public class Exercise1 {
    public static void main(String[] args) {
        Student s1 = new Student("Upul", "123@gmail.com");
        Student s2 = new Student("Nimal", "1234@gmail.com");
        Student s3 = new Student("kamal", "12345@gmail.com");
        s1.getDetails();
        s2.getDetails();
        s3.getDetails();
        int totalStudents = Student.totalStudents;
        System.out.println("Total students" + totalStudents);
    }
}
class Student {
    final String   studentId;
    String name;
    String email;

    public static int totalStudents;
    public static int studentCounter;

    public Student(String name, String email){
        this.name=name;
        this.email=email;
        this.studentCounter=studentCounter+1;
        this.studentId="STU"+studentCounter;
        this.totalStudents=totalStudents+1;

    }

    public void getDetails(){

        System.out.println("Student created:"+studentId+name+email);
    }
}
