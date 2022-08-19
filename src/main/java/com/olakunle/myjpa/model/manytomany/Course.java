package com.olakunle.myjpa.model.manytomany;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String courseCode;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "courseSet")
    private Set<Student> studentSet;

}
