package com.senn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan
@SpringBootApplication
public class EasyWorkflowApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyWorkflowApplication.class, args);
    }

}
