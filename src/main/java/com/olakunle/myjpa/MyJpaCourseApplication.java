package com.olakunle.myjpa;

import com.olakunle.myjpa.model.Department;
import com.olakunle.myjpa.model.Employee;
import com.olakunle.myjpa.model.EmployeeDetails;
import com.olakunle.myjpa.repository.DepartmentRepository;
import com.olakunle.myjpa.repository.EmployeeDetailsRepository;
import com.olakunle.myjpa.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
@Slf4j
@Component
public class MyJpaCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyJpaCourseApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (EmployeeRepository employeeRepository, EmployeeDetailsRepository employeeDetailsRepository, DepartmentRepository departmentRepository){
		return e -> {



//			One-to-One Relationships
//			EmployeeDetails employeeOneDetails = new EmployeeDetails(1L,"palm street", "medical", "male");
			EmployeeDetails employeeOneDetails = EmployeeDetails.builder()
					.id(1L)
					.address("palm street")
					.department("medical")
					.gender("male")
					.build();

			Employee employeeOne = Employee.builder()
					.employeeName("Dele")
					.employeeSalary(20000L)
					.employeeDesignation("doctor")
					.employeeDetails(employeeOneDetails)
					.build();

			employeeRepository.save(employeeOne);
//			employeeDetailsRepository.save(employeeOneDetails);

//			EmployeeDetails employeeTwoDetails = new EmployeeDetails(2L, "broad street, Oklahoma", "fire service", "male");
			EmployeeDetails employeeTwoDetails = EmployeeDetails.builder()
					.gender("male")
					.department("fire service")
					.id(2L)
					.address("broad street")
					.build();
			Employee employeeTwo = Employee.builder()
					.employeeName("Clement Stanford")
					.employeeSalary(25000L)
					.employeeDesignation("extinguisher")
					.employeeDetails(employeeTwoDetails)
					.build();

			employeeRepository.save(employeeTwo);
//			employeeDetailsRepository.save(employeeTwoDetails);


			/*
			 * One to Many JPA Mapping
			 * This uses the Department nd the Employee entities
			 * It explains that one department can have several employee, but one employee can have only one department
			 */

//			EmployeeDetails employeeThreeDetails = EmployeeDetails.builder()
//					.address("Mark Urban Lane")
//					.gender("male")
////					.employee(employeeThree)
//					.department("medical")
//					.build();
//
//			Employee employeeThree = Employee.builder()
//					.employeeName("Jake")
//					.employeeDesignation("Radiologist")
//					.employeeSalary(50000L)
//					.employeeDetails(employeeThreeDetails)
//					.build();
//
//			Department medicalDept = Department.builder()
//					.employees(List.of(employeeOne, employeeThree))
//					.name("Medical")
//					.build();
//
//			departmentRepository.save(medicalDept);


		};


	}

}
