package com.stemlink.tutor;

import java.time.LocalDateTime;
import java.time.format.FormatStyle;
import java.util.Date;

public class Exercise2 {
    public static void main(String[] args) {
        // Test BookingValidator
        System.out.println("=== Testing BookingValidator ===");
        LocalDateTime futureTime = LocalDateTime.now().plusDays(2);
        System.out.println("Future time valid? " +
                BookingValidator.isValidBookingTime(futureTime));
        System.out.println("3 hours valid? " +
                BookingValidator.isValidDuration(3));
        System.out.println("5 hours valid? " +
                BookingValidator.isValidDuration(5));

        // Test FeeCalculator
        System.out.println("\n=== Testing FeeCalculator ===");
        System.out.println("Standard 2h: LKR " +
                FeeCalculator.calculateTotal("STANDARD", 2));
        System.out.println("Urgent 3h: LKR " +
                FeeCalculator.calculateTotal("URGENT", 3));

        // Test DateTimeFormatter
        System.out.println("\n=== Testing DateTimeFormatter ===");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Standard: " +
                DateTimeFormatter.formatDateTime(now));
        System.out.println("Long: " +
                DateTimeFormatter.formatDateLong(now));
        System.out.println("Time: " +
                DateTimeFormatter.formatTime(now));
    }
}



 class BookingValidator {
    // Validates if booking time is in the future
    public static boolean isValidBookingTime(LocalDateTime bookingTime){
        LocalDateTime now = LocalDateTime.now();
        boolean result;

        if (bookingTime.isAfter(now)) {
            result = true;
        } else {
            result = false;
        }

        return result;

    }

    // Validates if duration is between 1 - 4 hours
    public static boolean isValidDuration(int hours){
        boolean result;
        if(1<=hours && hours<=4) {
            result = true;
        }
        else{
            result = false;
        }
        return result;
    }

    // Validates if time slot doesn't overlap with existing booking
//    public static boolean isSlotAvailable(
//            LocalDateTime newStart,
//            LocalDateTime newEnd,
//            LocalDateTime existingStart,
//            LocalDateTime existingEnd
//    ){
//
//    }
}


 class FeeCalculator {
    // Constants
    private static final double STANDARD_RATE = 1500.0;
    private static final double URGENT_RATE = 2500.0;
    private static final double GROUP_RATE = 1200.0;
    private static final double PLATFORM_FEE_PERCENTAGE = 0.15;

    // Calculates base fee based on booking type
    public static double calculateBaseFee(String bookingType, int hours){



        switch (bookingType){
            case "STANDARD":
                return STANDARD_RATE*hours;
            case "URGENT":
                return URGENT_RATE*hours;
            case "GROUP":
                return GROUP_RATE*hours;
            default:
                return 0;

        }

    }

    // Calculates platform fee (15% of base fee)
    public static double calculatePlatformFee(double baseFee){
        return baseFee*0.15;

    }

    // Calculates total (base + platform fee)
    public static double calculateTotal(String bookingType, int hours){
        double baseFee=calculateBaseFee(bookingType,hours);

        double platformfee=calculatePlatformFee(baseFee);
        return baseFee+platformfee;

    }
}



class DateTimeFormatter {
    // Formats to: "2025-11-16 14:30"
    public static String formatDateTime(LocalDateTime dateTime){

return dateTime.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

    }

    // Formats to: "November 16, 2025"
    public static String formatDateLong(LocalDateTime dateTime){
        return dateTime.format(java.time.format.DateTimeFormatter.ofPattern("MMMM d, yyyy"));
    }

    // Formats to: "2:30 PM"
    public static String formatTime(LocalDateTime dateTime){
        return dateTime.format(java.time.format.DateTimeFormatter.ofPattern("h:mm a"));
    }
}
