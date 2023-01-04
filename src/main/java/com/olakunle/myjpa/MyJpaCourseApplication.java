package com.olakunle.myjpa;


import com.olakunle.myjpa.model.Author;
import com.olakunle.myjpa.model.Book;
import com.olakunle.myjpa.repository.AuthorRepository;
import com.olakunle.myjpa.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@SpringBootApplication
@Slf4j
@Component
public class MyJpaCourseApplication {


    public static void main(String[] args) {
        SpringApplication.run(MyJpaCourseApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(BookRepository bookRepository, AuthorRepository authorRepository) {
        return e -> {
            Book bookOne = new Book();
            bookOne.setTitle("Awaken the giant within");
            bookOne.setPrice(1200L);
//			bookOne.setAuthorName("");
//			bookOne.setAuthorAddress();
            bookOne.setYear("2017");
            bookOne.setPublisherName("Free Press");

            Book bookTwo = new Book();
            bookTwo.setTitle("Unlimited Power");
            bookTwo.setPrice(1500L);
//			bookTwo.setAuthorName("");
//			bookTwo.setAuthorAddress();
            bookTwo.setYear("2004");
            bookTwo.setPublisherName("Free Press");

            Book bookThree = new Book();
            bookThree.setTitle("Money Master the game");
            bookThree.setPrice(2000L);
//			bookThree.setAuthorName("");
//			bookThree.setAuthorAddress();
            bookThree.setYear("2021");
            bookThree.setPublisherName("Free Press");


            Author toni = new Author();
            toni.setName("Anthony Robbins");
            toni.setAddress("North Hollywood, Los Angeles, California");
            toni.setUrl("https://www.tonyrobbins.com/tony-robbins-books/");
            toni.setBooks(Set.of(bookOne, bookTwo, bookThree));

            authorRepository.save(toni);
/**
 * The above code saved successfully, but the author-name and author-address has not be resolved.
 * also, no other reference was made in the Book class.
 */

            log.info(authorRepository.findByName("Anthony Robbins").get().getBooks().toString());
            log.info(authorRepository.findByName("Anthony Robbins").get().getBooks().toString());

        };
    }

}
