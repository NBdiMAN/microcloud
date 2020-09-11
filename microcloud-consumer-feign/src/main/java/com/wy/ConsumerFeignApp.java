package com.wy;

import com.whyme.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wangyang
 * @date 2020/8/15 13:44
 * @description:
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClients(defaultConfiguration = RibbonConfig.class)
@EnableFeignClients("com.wy.service")
public class ConsumerFeignApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignApp.class, args);
    }
}
