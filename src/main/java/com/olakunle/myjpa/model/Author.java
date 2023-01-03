package com.olakunle.myjpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import java.util.HashSet;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    private String url;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "books", referencedColumnName = "name")
    private Set<Book> books = new HashSet<>();
}
