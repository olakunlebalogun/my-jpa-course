package com.olakunle.myjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Library {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @OneToOne
    @JoinColumn(name = "address_id") // This is the appended column it references Address entity but represents it with address_id
    private Address address;
}
