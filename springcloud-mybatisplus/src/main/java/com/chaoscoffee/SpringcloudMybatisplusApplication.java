package com.chaoscoffee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chaoscoffee.mapper")
public class SpringcloudMybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudMybatisplusApplication.class, args);
    }
}
