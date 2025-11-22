package com.stemlink.tutor;

import java.time.LocalDateTime;

public class Exercise3 {
    public static void main(String[] args) {
        // Create a booking
        Booking booking1 = new Booking(
                "STU-001",
                "MEN-005",
                "Core Java OOP",
                LocalDateTime.of(2025, 11, 20, 14, 0)

        );

        System.out.println("Original Booking:");
        System.out.println(booking1.getBookingDetails());

        // Try to "modify" - must create new object
        Booking booking2 = new Booking(
                booking1.getStudentId(),
                booking1.getMentorId(),
                booking1.getSubject(),
                LocalDateTime.of(2025, 11, 21, 14, 0)

        );

        System.out.println("\n'Modified' Booking (new object):");
        System.out.println(booking2.getBookingDetails());

        // Demonstrate immutability
        System.out.println("\nAre they the same object? " + (booking1 == booking2));
//        System.out.println("Original booking unchanged? " +
//                (booking1.getDurationHours() == 2));
    }
}

class Booking {
   final String bookingId;
   final String studentId;
   final String mentorId ;
   final String subject;
   final LocalDateTime createdAt ;
   final String status="PENDING";

   public static int bookingCounter;
   int count;
   public Booking(String bookingId,String mentorId,String subject,LocalDateTime createdAt) {
       this.bookingId = bookingId;
       this.studentId = "STU"+count+1;
       this.mentorId = mentorId;
       this.subject = subject;
       this.createdAt = createdAt;

       this.bookingCounter=bookingCounter+1;
   }
       public String getBookingDetails(){

           System.out.println("Booking ID" + bookingId );
           System.out.println("studentId " + studentId );
           System.out.println("mentorId" + mentorId );
           System.out.println("createdAt" + createdAt);
           System.out.println("status" + status);

           return "";
       }

       public String getStudentId(){
           return studentId;
       }

       public  String getMentorId(){
         return mentorId;
       }

       public String getSubject(){
       return subject;
       }


}
