package com.olakunle.myjpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfile {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String addressOne;
    private String addressTwo;
    private String city;
    private String country;
    private LocalDate dob;
    private String gender;
    private String phoneNumber;
    private String state;
    private String street;
    private String zipCode;

    /**
     * This is a one-to-one mapping in Data JPA between User and UserProfile classes
     * This property relating to User has an attribute called mappedBy which removes the null that is the reference of the User in every UserProfile object created
     * To check out what this means, remove the attribute and check out the UserProfile in the database,
     * you will see that the column referencing the User will be NULL
     */
    @OneToOne(mappedBy = "userProfile")
    private User user;




}
