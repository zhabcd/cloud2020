package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author EiletXie
 * @Since 2020/3/11 13:35
 */

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
@RequestMapping("payment")
public interface PaymentFeignService {

    @GetMapping(value = "/get")
    CommonResult getPaymentById(@RequestParam("id") Long id);

    @GetMapping(value = "/feign/timeout")
    String paymentFeignTimeout();


}


