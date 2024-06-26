package com.atguigu.ssyx.common.exception;

import com.atguigu.ssyx.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * @author QRH
 * @date 2024/6/25 16:51
 * @description 自定义异常类
 */
@Data
public class CustomerException extends RuntimeException {
    //异常状态码
    private Integer code;

    /**
     * 通过状态码和错误消息创建异常对象
     *
     * @param message 异常信息
     * @param code 异常响应码
     */
    public CustomerException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    /**
     * 接收枚举类型对象
     * @param resultCodeEnum
     */
    public CustomerException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "CustomerException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
