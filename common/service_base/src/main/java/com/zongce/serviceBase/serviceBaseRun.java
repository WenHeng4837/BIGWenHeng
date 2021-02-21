package com.zongce.serviceBase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class serviceBaseRun {
    public static void main(String[] args) {
        SpringApplication.run(serviceBaseRun.class, args);
    }
}
