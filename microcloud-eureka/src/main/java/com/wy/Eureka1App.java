package com.wy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wangyang
 * @date 2020/8/15 15:31
 * @description:
 */
@EnableEurekaServer
@SpringBootApplication
public class Eureka1App {
    public static void main(String[] args) {
        SpringApplication.run(Eureka1App.class, args);
    }
}
