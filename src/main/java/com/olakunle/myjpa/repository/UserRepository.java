package com.olakunle.myjpa.repository;

import com.olakunle.myjpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
