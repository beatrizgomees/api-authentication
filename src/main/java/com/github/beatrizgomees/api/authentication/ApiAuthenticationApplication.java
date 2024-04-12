package com.github.beatrizgomees.api.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ApiAuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiAuthenticationApplication.class, args);
    }

}
