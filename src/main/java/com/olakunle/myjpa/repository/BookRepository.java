package com.olakunle.myjpa.repository;

import com.olakunle.myjpa.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
