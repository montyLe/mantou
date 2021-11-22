package com.mantou.mantoubo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.mantou.mantoubo.basic.mapper"})
public class MantouBoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MantouBoApplication.class, args);
    }

}
