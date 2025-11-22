package com.stemlink.tutor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise4 {
    public static void main(String[] args) {
        System.out.println("=== Creating Different Session Requests ===\n");

        // 1. Simple session (only required fields)
        SessionRequest simple = new SessionRequest.Builder(
                "STU-001",
                "MEN-003",
                "Java Basics"
        ).build();

        System.out.println("1. Simple Session:");
        System.out.println(simple);
        System.out.println();

        // 2. Detailed session with notes and materials
        SessionRequest detailed = new SessionRequest.Builder(
                "STU-002",
                "MEN-005",
                "Spring Boot REST APIs"
        )
                .sessionNotes("Focus on exception handling and validation")
                .materialsNeeded(Arrays.asList("Laptop", "Spring Boot docs", "Postman"))
                .preferredTime(LocalDateTime.now().plusDays(3))
                .build();

        System.out.println("2. Detailed Session:");
        System.out.println(detailed);
        System.out.println();

        // 3. Urgent session
        SessionRequest urgent = new SessionRequest.Builder(
                "STU-003",
                "MEN-002",
                "Database Design"
        )
                .isUrgent(true)
                .preferredTime(LocalDateTime.now().plusDays(2))
                .sessionNotes("Need help before exam!")
                .build();

        System.out.println("3. Urgent Session:");
        System.out.println(urgent);
        System.out.println();

        // 4. Group session
        SessionRequest group = new SessionRequest.Builder(
                "STU-004",
                "MEN-001",
                "React Fundamentals"
        )
                .maxStudents(4)
                .materialsNeeded(Arrays.asList("Laptop", "VS Code", "Node.js installed"))
                .build();

        System.out.println("4. Group Session:");
        System.out.println(group);
        System.out.println();

        // 5. Test validation - try invalid group size
        try {
            SessionRequest invalid = new SessionRequest.Builder(
                    "STU-005",
                    "MEN-002",
                    "Advanced Java"
            )
                    .maxStudents(1) // Should be at least 2 for group
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("5. Validation Test:");
            System.out.println("✅ Caught error: " + e.getMessage());
        }
    }
}


class SessionRequest {
    // Final fields
    private final String studentId;
    private final String mentorId;
    private final String subject;
    // ... other fields

    // Private constructor
    private SessionRequest(Builder builder) {
        this.studentId = builder.studentId;
        this.mentorId = builder.mentorId;
        this.subject = builder.subject;
        // ... initialize all fields from builder
    }

    // Getters only
    public String getStudentId() {
        return studentId;
    }
    // ... other getters

    public String getSubject() {
        return subject;
    }

    public String getMentorId() {
        return mentorId;
    }

    @Override
    public String toString() {
        // Return formatted details
    }

    // Static nested Builder class
    public static class Builder {
        // Required parameters (final)
        private final String studentId;
        private final String mentorId;
        private final String subject;

        // Optional parameters (with defaults)
        private String sessionNotes = "";
        List<String> materialsNeeded = new ArrayList<>();
        private boolean isUrgent = false;
        private LocalDateTime preferredTime = null;
        private int maxStudents = 1;

        // Constructor with required parameters
        public Builder(String studentId, String mentorId, String subject) {
            this.studentId = studentId;
            this.mentorId = mentorId;
            this.subject = subject;
        }

        // Fluent setter methods
        public Builder sessionNotes(String notes) {
            this.sessionNotes = notes;
            return this;
        }

        // TODO: Implement other fluent setters

        // Build with validation
        public SessionRequest build() {
            // TODO: Add validation logic
            return new SessionRequest(this);
        }

        public Object materialsNeeded(List<String> list) {

        }
    }
}
