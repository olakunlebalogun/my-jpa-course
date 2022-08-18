package com.olakunle.myjpa.repository;

import com.olakunle.myjpa.model.onetoone.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
