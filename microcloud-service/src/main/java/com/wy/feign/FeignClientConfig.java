package com.wy.feign;

import feign.Feign;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangyang
 * @date 2020/8/19 17:55
 * @description:
 */
@Configuration
public class FeignClientConfig {

    @Bean
    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("admin","123456");
    }

    /**
     *feign日志级别默认为none，即使加上了logging，也打印不出来，需要重新设置一下FULL
     * @return
     */
    @Bean
    public Logger.Level getFeignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
