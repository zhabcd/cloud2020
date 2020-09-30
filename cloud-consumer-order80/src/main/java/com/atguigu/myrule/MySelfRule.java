package com.atguigu.myrule;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jack
 * @version V1.0
 * @Package com.atguigu.myrule
 * @date 2020/9/28 12:45
 * @description
 */

@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return new BestAvailableRule();//定义为随机
    }
}


