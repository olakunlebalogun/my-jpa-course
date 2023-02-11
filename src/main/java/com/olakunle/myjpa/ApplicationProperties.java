package com.olakunle.myjpa;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@ConfigurationProperties(value = "spring.data.mongodb")
@Component
@Data
@Validated
public class ApplicationProperties {

    @NotEmpty
    private String database;
    @Positive
    @NotEmpty
    private String port;
    @NotEmpty
    private String password;
    @NotNull
    private String host;



}
