package com.olakunle.myjpa.repository;

import com.olakunle.myjpa.model.onetoone.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
