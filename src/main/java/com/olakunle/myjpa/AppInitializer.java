package com.olakunle.myjpa;

import com.olakunle.myjpa.entity.*;
import com.olakunle.myjpa.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Slf4j
@RequiredArgsConstructor
public class AppInitializer implements CommandLineRunner {

    private final ApplicationProperties applicationProperties;
    private final TenantRepository tenantRepository;
    private final LandLordRepository landLordRepository;

    private final LibraryRepository libraryRepository;
    private final AddressRepository addressRepository;

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    @Value("${spring.data.mongodb.port}")
    private String port;

    @Value("${spring.data.mongodb.password: defaultPassword}")
    private String password;

    @Value("${spring.data.mongodb.host}")
    private String host;


    @Override
    public void run(String... args) throws Exception {
        log.info("Mongo password: {}", password);
        log.info("Mongo port: {}", port);
        log.info("Mongo host: {}", host);

        System.out.println("------------------Application Properties -----------------------");

        log.info("Application Properties, password: {}", applicationProperties.getPassword());
        log.info("Application Properties, host: {}", applicationProperties.getHost());
        log.info("Application Properties, port: {}", applicationProperties.getPort());
        log.info("Application Properties, database: {}", applicationProperties.getDatabase());

                    /**                                                                                         //**
                     * =========================================================================================*!!
                     *   //FIXME:   INPUTTING DATA FOR ONE TO ONE RELATIONSHIP WITH LIBRARY AND ADDRESS CLASSES **
                     * =========================================================================================*!!
                     */                                                                                         //**

        Address address = new Address(); // NOTE: Only one instance of this entity can be created
//        address.setId(); // Auto-set
        address.setLocation("Yaba, Muson Street");
        addressRepository.save(address);


        Library library = new Library();// NOTE: Only one instance of this entity can be created
        library.setName("Moremi Memorial Library");
        library.setAddress(address);

        libraryRepository.save(library);



                        /**
                         * =========================================================================================*!!
                         *   //FIXME:   INPUTTING DATA FOR ONE TO MANY RELATIONSHIP WITH LANDLORD AND TENANT CLASSES
                         * =========================================================================================*!!
                         */
        Tenant tenantOne = new Tenant(); // Child entity one
//        tenantOne.setId(1);  //This is not require because the entity generates automatically i.e GenerateType.AUTO
        tenantOne.setName("Anthony Samuel");


        Tenant tenantTwo = new Tenant(); // Child entity two
//        tenantTwo.setId(2); //This is not require because the entity generates automatically i.e GenerateType.AUTO
        tenantTwo.setName("Lawrence Gibson");


        LandLord landlordOne = new LandLord();  // Parent entity One
//        landlordOne.setId(1); // This is not require because the entity generates automatically i.e GenerateType.AUTO
        landlordOne.setHouseId("Street_001");
        landlordOne.setName("Mr. Peter");

        tenantTwo.setLandLord(landlordOne); // Note: Setting back the referenced id for child entity one
        tenantOne.setLandLord(landlordOne); // Note: Setting back the referenced id for child entity one
        landlordOne.getTenants().addAll(List.of(tenantTwo, tenantOne)); // Note: Adding the tenants (Child entities) to the parent.

        landLordRepository.save(landlordOne); // Saving parent to repository.


                    /**
                     * =========================================================================================*!!
                     *   //FIXME:   INPUTTING DATA FOR MANY-TO-MANY RELATIONSHIP WITH LANDLORD AND TENANT CLASSES
                     * =========================================================================================*!!
                     */


        Student std1 = new Student();
        std1.setFirstName("Mike");
        std1.setLastName("Dean");



        Student std2 = new Student();
        std2.setFirstName("Mosh");
        std2.setLastName("Hamadeni");



        Student std3 = new Student();
        std3.setFirstName("Brad");
        std3.setLastName("Traversy");



        Course courseOne = new Course();
        courseOne.setTitle("Fluid Mechanics");
        std1.getCourses().add(courseOne);
        std3.getCourses().add(courseOne);
        courseOne.setDescription("Fluid flow and analysis");
        courseOne.getStudents().addAll(List.of(std1, std2, std3));

        courseRepository.save(courseOne);



        Course courseTwo = new Course();
        courseTwo.setTitle("Electromagnetism");
        courseTwo.setDescription("Theory of Electricity and Magnetism");
        courseTwo.getStudents().addAll(List.of(std1, std3));
        std1.getCourses().add(courseTwo);
        std2.getCourses().add(courseTwo);


        courseRepository.save(courseTwo);

        Course courseThree = new Course();
        courseThree.setTitle("Thermodynamics");
        courseThree.setDescription("Study of heat flow and exchange");
        courseThree.getStudents().addAll(List.of(std3, std2));
        std2.getCourses().add(courseThree);
        std3.getCourses().add(courseThree);

        courseRepository.save(courseThree);

        studentRepository.save(std1);
        studentRepository.save(std2);
        studentRepository.save(std3);











    }
}
