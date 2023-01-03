package com.olakunle.myjpa.model;

import lombok.*;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import java.util.HashSet;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    private String url;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "books", referencedColumnName = "name")
    private Set<Book> books = new HashSet<>();
}
