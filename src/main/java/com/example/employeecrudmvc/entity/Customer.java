package com.example.employeecrudmvc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "FirstName cannot be empty!")
    @NotBlank(message = "FirstName cannot be blank!")
    private String firstName;

    @NotEmpty(message = "LastName cannot be empty!")
    @NotBlank(message = "LastName cannot be blank!")
    private String lastName;

    @Email(message = "Invalid Email Format!")
    @NotEmpty(message = "Email cannot be empty!")
    @NotBlank(message = "Email cannot be blank!")
    private String email;

    @Pattern(regexp = "[a-zA-Z0-9-]*", message = "PhoneNumber cannot contain illegal characters!")
    @NotEmpty(message = "PhoneNumber cannot be empty!")
    @NotBlank(message = "PhoneNumber cannot be blank!")
    private String phoneNumber;

    @Past(message = "Date Of Birth must be past.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    public Customer(String firstName, String lastName, String email, String phoneNumber, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }
}