package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced // 使用自定义的LoadBalanced需要注释掉
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}


