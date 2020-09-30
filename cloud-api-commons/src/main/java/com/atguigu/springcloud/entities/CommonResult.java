package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jack
 * @version V1.0
 * @Package com.atguigu.springcloud.entities
 * @date 2020/9/27 14:05
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    public static CommonResult ok() {
        return CommonResult.ok(200, "success", null);
    }

    public static CommonResult ok(Object data) {
        return CommonResult.ok(200, "success", data);
    }
    public static CommonResult ok(String message, Object data) {
        return CommonResult.ok(200, message, data);
    }
    public static CommonResult ok(Integer code, String message) {
        return CommonResult.ok(200, message, null);
    }
    public static CommonResult ok(Integer code, String message, Object data) {
        return new CommonResult<>(code, message, data);
    }

    public static CommonResult error() {
        return CommonResult.error(100, "操作失误");
    }

    public static CommonResult error(String message) {
        return CommonResult.error(100, message);
    }

    public static CommonResult error(Integer code, String message) {
        return new CommonResult<>(code, message);
    }
}


