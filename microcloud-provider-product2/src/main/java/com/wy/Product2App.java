package com.wy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.wy.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
public class Product2App {
    public static void main(String[] args) {
        SpringApplication.run(Product2App.class,args);
    }
}