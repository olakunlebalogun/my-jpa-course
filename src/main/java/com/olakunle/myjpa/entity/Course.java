package com.olakunle.myjpa.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String description;

    @ManyToMany(mappedBy = "courses")
    // Note: Associations marked as mappedBy must NOT define database mappings like @JoinTable or @JoinColumn
    private List<Student> students = new ArrayList<>();
}
