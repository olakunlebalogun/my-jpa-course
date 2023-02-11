package com.olakunle.myjpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.olakunle.myjpa", "com.olakunle.jpamodel"})
@Slf4j
@EnableConfigurationProperties
public class MyJpaCourseApplication {




	public static void main(String[] args) {


		SpringApplication.run(MyJpaCourseApplication.class, args);
	}

	@Component
	class AppInitializer implements CommandLineRunner {

		@Value("${spring.data.mongodb.database}")
		private String database;
		@Override
		public void run(String... args) throws Exception {
			log.info("Mongo Database: {}" , database);
		}
	}
}
