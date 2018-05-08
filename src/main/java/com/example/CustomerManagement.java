package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by araksgyulumyan
 * Date - 5/8/18
 * Time - 4:44 PM
 */
@EnableAutoConfiguration
@SpringBootApplication
@EnableJpaRepositories
@EnableWebMvc
@ComponentScan("com.example.*")
public class CustomerManagement {

    public static void main(String[] args) {
        SpringApplication.run(CustomerManagement.class, args);
    }

}
