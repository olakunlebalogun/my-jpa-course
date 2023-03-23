package com.olakunle.myjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String location;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private Library library;
}
