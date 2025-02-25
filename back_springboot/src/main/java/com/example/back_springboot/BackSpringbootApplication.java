package com.example.back_springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.back_springboot.mapper")//告诉springboot在哪个位置找到mapper接口
public class BackSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackSpringbootApplication.class, args);
    }

}
