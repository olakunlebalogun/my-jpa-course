package com.olakunle.myjpa.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String employeeName;
    private Long employeeSalary;
    private String employeeDesignation;


    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "details_id", referencedColumnName = "id")
    private EmployeeDetails employeeDetails;


    @ManyToOne(cascade =CascadeType.MERGE)
//    @JoinColumn(name =  "employeeDept", referencedColumnName = "name")
    private Department department;
}
