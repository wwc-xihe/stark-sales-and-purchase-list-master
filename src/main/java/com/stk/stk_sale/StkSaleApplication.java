package com.stk.stk_sale;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.stk.stk_sale.mapper")
public class StkSaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(StkSaleApplication.class, args);
    }

}
