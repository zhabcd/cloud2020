package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author EiletXie
 * @Since 2020/3/10 14:54
 */
@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/zk")
    public String paymentzk() {
        return "springcloud with zookeeper:" + serverPort + "\t"
                + UUID.randomUUID().toString();
    }
    /**
     * 启动好以后访问http://localhost:8004/payment/zk
     * springcloud with zookeeper:8004 ef57c824-e72a-4401-bc4e-7b9defe0ea75
     */
}
