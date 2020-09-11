package com.wy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.internal.EnableZipkinServer;

/**
 * @author wangyang
 * @date 2020/9/1 0:04
 * @description:
 */
@SpringBootApplication
@EnableZipkinServer
public class SleuthApp {
    public static void main(String[] args) {
        SpringApplication.run(SleuthApp.class, args);
    }
}
