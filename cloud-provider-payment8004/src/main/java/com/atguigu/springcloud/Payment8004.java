package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author EiletXie
 * @Since 2020/3/10 14:51
 */
@SpringBootApplication
@EnableDiscoveryClient //该注解用于向使用consul或者zookeeper作为注册中心时注册服务
public class Payment8004 {

    public static void main(String[] args) {
        SpringApplication.run(Payment8004.class,args);
    }
    /**
     * 先启动zookeeper再启动8004，启动后查看zookeeper客户端
     * [zk: localhost:2181(CONNECTED) 12] ls /services/cloud-provider-payment
     * [3883f822-b5e0-4cc8-b904-6dec7483b3f6]
     */

}
