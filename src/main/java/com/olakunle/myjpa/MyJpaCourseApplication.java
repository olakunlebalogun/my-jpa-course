package com.olakunle.myjpa;


import com.olakunle.myjpa.model.User;
import com.olakunle.myjpa.model.UserProfile;
import com.olakunle.myjpa.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@SpringBootApplication
@Slf4j
@Component
public class MyJpaCourseApplication {
	private final UserProfileRepository userProfileRepository;

	public MyJpaCourseApplication(UserProfileRepository userProfileRepository) {
		this.userProfileRepository = userProfileRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MyJpaCourseApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (UserRepository userRepository, UserProfileRepository userProfileRepository
	){
		return e -> {

			UserProfile olalekanProfile = new UserProfile();
			olalekanProfile.setAddressOne("Igbanda Ibadan");
			olalekanProfile.setAddressTwo("Raoni Ikorodu");
			olalekanProfile.setCity("Lagos");
			olalekanProfile.setCountry("Nigeria");
			olalekanProfile.setDob(LocalDate.of(1987, 6, 6));
			olalekanProfile.setGender("Male");
			olalekanProfile.setPhoneNumber("08167572919");
			olalekanProfile.setState("Kwara");
			olalekanProfile.setStreet("Raoni");
			olalekanProfile.setZipCode("101121");

			User firstUser = new User();
			firstUser.setFirstName("Olalekan");
			firstUser.setLastName("Balogun");
			firstUser.setPassword("ola0606");
			firstUser.setEmailAddress("olalekan@gmail.com");
			firstUser.setUserProfile(olalekanProfile);


			userRepository.save(firstUser);



			// Olanrewaju Profile
			UserProfile lanreProfile = new UserProfile();
			lanreProfile.setAddressOne("Ogbomosho");
			lanreProfile.setAddressTwo("Ikorodu");
			lanreProfile.setCity("Oyo");
			lanreProfile.setCountry("Nigeria");
			lanreProfile.setDob(LocalDate.of(1990, 10, 26));
			lanreProfile.setGender("Male");
			lanreProfile.setPhoneNumber("0810187741");
			lanreProfile.setState("Kwara");
			lanreProfile.setStreet("Raoni");
			lanreProfile.setZipCode("101121");

			User secondUser = new User();
			secondUser.setFirstName("Olalekan");
			secondUser.setLastName("Balogun");
			secondUser.setPassword("lanre1026");
			secondUser.setEmailAddress("Olanrewaju@gmail.com");
			secondUser.setUserProfile(lanreProfile);


			userRepository.save(secondUser);



//			userProfileRepository.delete(olalekanProfile);

//			log.info(userRepository.findById(1L).get().getUserProfile().getCountry());


		};


	}

}
