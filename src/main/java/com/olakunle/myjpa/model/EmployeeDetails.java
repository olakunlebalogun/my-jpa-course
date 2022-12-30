package com.olakunle.myjpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    private String department;
    private String gender;
//    private String jobTitle;
//    private BigDecimal salary;

    @OneToOne( mappedBy = "employeeDetails")
    private Employee employee;

}
