package com.wy;

import com.whyme.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * @author wangyang
 * @date 2020/8/15 13:44
 * @description:
 */
@SpringBootApplication
@RibbonClients(defaultConfiguration = RibbonConfig.class)
public class ConsumerRibbonApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbonApp.class, args);
    }
}
