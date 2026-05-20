package com.example.basics_of_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BasicsOfSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicsOfSpringbootApplication.class, args);
    }
    @GetMapping
    public String hello(){
        return "Hello spring ji!";
    }

}
