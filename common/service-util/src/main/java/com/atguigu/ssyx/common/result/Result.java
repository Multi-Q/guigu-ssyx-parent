package com.atguigu.ssyx.common.result;

import com.atguigu.ssyx.common.exception.CustomerException;
import lombok.Data;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author QRH
 * @date 2024/6/25 15:27
 * @description 同一结果返回类
 */


@Data
public class Result<T> {

    //状态码
    private Integer code;
    //信息
    private String message;
    //数据
    private T data;
    private final Long timeStamp;

    //构造私有化
    private Result() {
        this.timeStamp = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 设置数据,返回对象的方法
     *
     * @param data           返回的数据
     * @param resultCodeEnum 返回的状态码
     */
    private static <T> Result<T> build(T data, ResultCodeEnum resultCodeEnum) {
        Result<T> result = new Result<>();
        if (data != null) {
            result.setData(data);
        }
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    /**
     * 构建返回信息
     *
     * @param reason 错误原因
     * @param <T>    Object
     * @return
     */
    public static <T> Result<T> build(String reason) {
        Result<T> result = new Result<>();
        result.setCode(ResultCodeEnum.FAIL.getCode());
        result.setData(null);
        result.setMessage(reason);
        return result;
    }



    /**
     * 成功的响应，不返回数据
     *
     * @return
     */
    public static <T> Result<T> ok() {
        return build(null, ResultCodeEnum.SUCCESS);
    }

    /**
     * 成功的方法
     *
     * @param data 返回的数据
     * @param <T>  任意类型
     * @return
     */
    public static <T> Result<T> ok(T data) {
        return build(data, ResultCodeEnum.SUCCESS);
    }


    /**
     * 失败的方法
     *
     * @return
     */
    public static <T> Result<T> fail() {
        return build(null, ResultCodeEnum.FAIL);
    }

    /**
     * 失败的方法
     *
     * @param reason 提示信息
     * @param <T>    任意类型
     * @return
     */
    public static <T> Result<T> fail(String reason) {
        ResultCodeEnum returnCodeEnum = ResultCodeEnum.getReturnCodeEnum(reason);
        if (Optional.ofNullable(returnCodeEnum).isPresent()) {
            return build(null, returnCodeEnum);
        } else {
            return build(reason);
        }
    }


    /**
     * 失败的方法
     *
     * @param data 数据
     * @param e    枚举类型，返回值信息
     * @return
     */
    public static <T> Result<T> fail(T data, ResultCodeEnum e) {
        return build(data, e);
    }

    /**
     * 构建返回信息 这个方法主要用来捕获异常的
     *
     * @param e 自定义异常类
     * @param <T>
     * @return
     */
    public static <T> Result<T> fail(CustomerException e) {
        Result<T> result = new Result<>();
        result.setMessage("Exception:"+e.getClass().getName()+"{" +e.getMessage()+"}");
        result.setCode(e.getCode());
        result.setData(null);
        return result;
    }
}