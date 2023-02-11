package com.olakunle.myjpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@RequiredArgsConstructor
public class AppInitializer implements CommandLineRunner {

    private final ApplicationProperties applicationProperties;

    @Value("${spring.data.mongodb.port}")
    private String port;

    @Value("${spring.data.mongodb.password}")
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


    }
}
