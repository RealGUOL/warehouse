package com.realguo.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.realguo.web.dao"})
public class WarehouseWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarehouseWebApplication.class, args);
    }

}
