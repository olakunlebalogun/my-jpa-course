package com.olakunle.myjpa.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book implements Serializable {

    // Using UUID as a generation strategy for the ISBN
    // TODO: Try the Custom method Generator for the ISBN


    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")


    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "isbn")
    private String ISBN;


    private String publisherName;

    @Column(name = "author")
    private String authorName;
    private String authorAddress;
    private String year;
    private String title;
    private Long price;

    // TODO:
    @ManyToOne()
    private Author author;

}
