package com.wy.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @author wangyang
 * @date 2020/8/15 13:11
 * @description:
 */
@Configuration
public class RestConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public HttpHeaders getHeaders(){
        HttpHeaders httpHeaders = new HttpHeaders();
        String auth = "admin:123456";
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);
        httpHeaders.set("Authorization", authHeader);
        return httpHeaders;
    }

    /**
     * IRule就是所有规则的标准
     * @return
     */
    /*@Bean
    public IRule ribbonRule(){
        //随机的访问策略
        return new com.netflix.loadbalancer.RandomRule();
    }*/
}
