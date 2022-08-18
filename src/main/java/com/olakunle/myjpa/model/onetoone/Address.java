package com.olakunle.myjpa.model.onetoone;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String street;
    private String city;
    private String country;
    private String postalCode;
    @OneToOne(cascade = CascadeType.ALL)
    private Employee employee;

}
