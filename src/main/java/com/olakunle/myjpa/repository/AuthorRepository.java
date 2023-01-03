package com.olakunle.myjpa.repository;

import com.olakunle.myjpa.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
