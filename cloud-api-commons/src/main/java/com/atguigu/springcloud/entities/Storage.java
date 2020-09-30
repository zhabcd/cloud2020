package com.atguigu.springcloud.entities;

import lombok.Data;

/**
 * @author jack
 * @version V1.0
 * @Package com.atguigu.springcloud.entities
 * @date 2020/9/29 18:21
 * @description
 */

@Data
public class Storage {

    private Long id;

    // 产品id
    private Long productId;

    //总库存
    private Integer total;


    //已用库存
    private Integer used;


    //剩余库存
    private Integer residue;
}


