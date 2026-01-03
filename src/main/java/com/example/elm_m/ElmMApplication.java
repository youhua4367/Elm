package com.example.elm_m;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ElmMApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElmMApplication.class, args);
    }

}
