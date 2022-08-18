package com.olakunle.myjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.olakunle.myjpa", "com.olakunle.jpamodel"})

public class MyJpaCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyJpaCourseApplication.class, args);
	}

}
