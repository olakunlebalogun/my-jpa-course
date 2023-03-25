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
    // Note: Associations marked as mappedBy must NOT define database mappings like @JoinTable or @JoinColumn
//    @JoinColumn(name = "library_id", referencedColumnName = "id")  // test: changing if two @JoinColumn can be used. RESULT: It don't change the output.
    private Library library;
}
