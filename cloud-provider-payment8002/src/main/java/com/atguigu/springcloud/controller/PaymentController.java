package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment) {
        log.info("请求：" + payment);
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);
        log.info("*****插入结果34：" + result);
        if (result > 0) {  //成功
            return new CommonResult(200, "插入数据库成功，serverPort："+serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/get")
    public CommonResult getPaymentById(@RequestParam("id") Long id) {
        log.info("请求：" + id);
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果：" + payment);
        if (payment != null) {  //说明有数据，能查询成功
            return CommonResult.ok("查询成功，serverPort："+serverPort,payment);
        } else {
            return CommonResult.error(444, "没有对应记录，查询ID：" + id);
        }
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB(){
        return serverPort;
    }





}


