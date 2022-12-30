package com.olakunle.myjpa;

import com.olakunle.myjpa.model.Employee;
import com.olakunle.myjpa.model.EmployeeDetails;
import com.olakunle.myjpa.repository.EmployeeDetailsRepository;
import com.olakunle.myjpa.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Slf4j
@Component
public class MyJpaCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyJpaCourseApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (EmployeeRepository employeeRepository, EmployeeDetailsRepository employeeDetailsRepository){
		return e -> {

//			One-to-One Relationships
//			EmployeeDetails employeeOneDetails = new EmployeeDetails(1L,"palm street", "medical", "male");
			EmployeeDetails employeeOneDetails = EmployeeDetails.builder()
					.id(1L)
					.address("palm street")
					.department("medical")
					.gender("male")
					.build();
			Employee employeeOne = new Employee(1L,"Dele", 20000L, "doctor",employeeOneDetails );

			employeeRepository.save(employeeOne);
			employeeDetailsRepository.save(employeeOneDetails);

//			EmployeeDetails employeeTwoDetails = new EmployeeDetails(2L, "broad street, Oklahoma", "fire service", "male");
			EmployeeDetails employeeTwoDetails = EmployeeDetails.builder()
					.gender("male")
					.department("fire service")
					.id(2L)
					.address("broad street")
					.build();
			Employee employeeTwo = new Employee(2L,"Clement Stanford",25000L, "extinguisher", employeeTwoDetails );

			employeeRepository.save(employeeTwo);
//			employeeDetailsRepository.save(employeeTwoDetails);


		};


	}

}
