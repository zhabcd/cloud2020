package com.atguigu.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author EiletXie
 * @Since 2020/3/11 12:24
 */
@Component
@Slf4j
public class MyLB implements LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

//    public final int getAndIncrement() {
//        int current;
//        int next;
//        do {
//            current = this.atomicInteger.get();
//            next = current >= 2147483647 ? 0 : current + 1;
//        } while(!this.atomicInteger.compareAndSet(current,next));
//        log.info("****第几次访问，次数next: " + next);
//        return next;
//    }

    public final int getAndIncrement(){
        int c;
        int n;
        do{
            c = this.atomicInteger.get();
            n = c>=2147483647?0:c+1;
        }while (!this.atomicInteger.compareAndSet(c,n));
        log.info("****第几次访问，次数next: " + n);
        return n;
    }

    // 负载均衡轮询算法，rest接口第几次请求数 % 服务器集群总数 = 实际调用服务器位置下标
    @Override
    public ServiceInstance instances(List< ServiceInstance > serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
