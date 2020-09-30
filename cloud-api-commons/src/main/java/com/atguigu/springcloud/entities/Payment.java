package com.atguigu.springcloud.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Package com.atguigu.springcloud.entities
 * @author jack
 * @date 2020/9/27 14:04
 * @version V1.0
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
}



