package com.company.spring.data.jpa.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  //mapping this class to database
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    private Long studentId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;
}
