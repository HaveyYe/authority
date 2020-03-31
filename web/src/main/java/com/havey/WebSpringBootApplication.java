package com.havey;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "com.havey.mapper.dao")
public class WebSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSpringBootApplication.class,args);
    }
}

