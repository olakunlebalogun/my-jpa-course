package com.olakunle.myjpa;

import com.olakunle.myjpa.model.onetomany.Customer;
import com.olakunle.myjpa.model.onetomany.ShoppingBasket;
import com.olakunle.myjpa.repository.CustomerRepository;
import com.olakunle.myjpa.repository.ShoppingBasketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
@EnableEurekaClient
//@ComponentScan(basePackages = {"com.olakunle.myjpa", "com.olakunle.jpamodel"})

public class MyJpaCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyJpaCourseApplication.class, args);
	}

	// Autowired Beans
//	private final CustomerRepository customerRepository;

	@Bean
	CommandLineRunner commandLineRunner (CustomerRepository customerRepository, ShoppingBasketRepository shoppingBasketRepository) {
		return run -> {
			log.info("My JPA Course");
			log.info(String.valueOf(customerRepository.count()));
			System.out.println("Before Adding Data");

			// creating customer
			var douglas = Customer.builder()
					.phone("08023232123")
					.address("Oakland, Maryland")
					.name("Douglas McKinsley")
					.email("douglasmckins@gmail.com")
					.build();

			// creating shopping basket
			ShoppingBasket.builder()
					.customer(douglas);

			log.info(String.valueOf(customerRepository.count()));
			log.info(String.valueOf(shoppingBasketRepository.count()));
		};
	}

}
