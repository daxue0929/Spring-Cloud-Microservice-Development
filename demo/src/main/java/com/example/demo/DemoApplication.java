package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * http://localhost:8082
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.example.demo")
public class DemoApplication {

    public static void main(String[] args) {
        // Spring Boot是可以屏蔽命令行的
        SpringApplication application = new SpringApplication(DemoApplication.class);
        application.setAddCommandLineProperties(false);
        application.run(args);
    }

}
