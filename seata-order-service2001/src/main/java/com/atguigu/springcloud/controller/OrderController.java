package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Order;
import com.atguigu.springcloud.service.IdGeneratorSnowflake;
import com.atguigu.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author EiletXie
 * @Since 2020/3/18 21:15
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;
    @Resource
    private IdGeneratorSnowflake idGeneratorSnowflake;

    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    @GetMapping("/order/create")
    // http://localhost:2001/order/create?userId=1&productId=1&count=10&money=100

    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }


    /**
     * 生成id,通过雪花算法
     *
     * @return
     */
    @GetMapping("/snowflake")
    public String getIDBySnowflake() {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            threadPool.submit(() -> {
                System.out.println(idGeneratorSnowflake.snowflakeId());
            });
        }
        threadPool.shutdown();
        return "hello snowflake";
    }
}
