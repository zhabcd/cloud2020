package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("consumer")
@Slf4j
public class OrderController {

    // 不能写死
//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";



    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        log.info("请求：" + payment);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);  //写操作
    }

    @GetMapping("/payment/get")
    public CommonResult<Payment> getPayment(@RequestParam("id") Long id) {
        log.info("请求：" + id);
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get?id=" + id, CommonResult.class);
    }

    @GetMapping("/payment/get2")
    public CommonResult<Payment> getPayment2(@RequestParam("id") Long id) {
        log.info("请求：" + id);
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get?id=" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return CommonResult.error("查询不到");
        }
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        // 通过容器中的 discoveryClient和服务名来获取服务集群
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size() <= 0) {
            return null;
        }
        // 传入服务集群来计算出获取具体的服务实例
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        log.info("url："+uri);
        return  restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

    @GetMapping(value="/consumer/payment/zipkin")
    public String paymentZipkin() {
        return restTemplate.getForObject( "http://localhost:8001/payment/zipkin/",String.class);
    }
}


