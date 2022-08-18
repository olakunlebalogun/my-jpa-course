package com.olakunle.myjpa.repository;

import com.olakunle.myjpa.model.onetomany.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
