package com.chaoscoffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class SpringcloudJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudJpaApplication.class, args);
    }
}
