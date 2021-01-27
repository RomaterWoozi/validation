package com.wuzx.validation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.wuzx.validation.mapper")
public class ValidationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidationApplication.class, args);
    }

}
