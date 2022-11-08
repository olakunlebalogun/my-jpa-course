package com.olakunle.myjpa.repository;

import com.olakunle.myjpa.model.onetomany.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
