package com.olakunle.myjpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
@EnableEurekaClient

public class MyJpaCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyJpaCourseApplication.class, args);
	}

}
