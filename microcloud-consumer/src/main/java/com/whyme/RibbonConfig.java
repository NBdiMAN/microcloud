package com.whyme;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangyang
 * @date 2020/8/17 14:52
 * @description:
 */
public class RibbonConfig {
    /**
     * IRule就是所有规则的标准
     * @return
     */
    @Bean
    public IRule ribbonRule(){
        //随机的访问策略
        return new com.netflix.loadbalancer.RandomRule();
    }
}
