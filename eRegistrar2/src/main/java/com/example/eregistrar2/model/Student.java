package com.example.eregistrar2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    //@NotNull
    private String studentNumber;

    @NotNull
    private String firstName;

    private String middleName;

    //@NotNull
    private String lastName;

    private String email;

    private double cgpa;

    private LocalDate dateOfEnrollment;

    private String isInternational;
    ;


}
