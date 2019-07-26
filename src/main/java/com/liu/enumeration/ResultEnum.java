package com.liu.enumeration;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: Liu
 * @Date: 2019/7/21 20:36
 * @Description:
 */
@Data
public class ResultEnum<T> implements Serializable {

    private static final long serialVersionUID = -2577674977245787832L;

    private Integer code;

    private String massage;

    private T data;

    public ResultEnum(Integer code, String massage) {
        this.code = code;
        this.massage = massage;
    }

    public ResultEnum(Integer code, String massage, T data) {
        this.code = code;
        this.massage = massage;
        this.data = data;
    }

    public static ResultEnum SUCCESS() {
        return new ResultEnum(200, "成功");
    }

    public static ResultEnum ERROR() {
        return new ResultEnum(400,"错误");
    }

    public static ResultEnum SUCCESS(Object data) {
        return new ResultEnum(200, "成功", data);
    }

    public static <T> ResultEnum<T> CUSTOM(IEnum enumeration, T data) {
        return new ResultEnum(enumeration.getCode(), enumeration.getMassage(), data);
    }

    public static  ResultEnum CUSTOM(IEnum enumeration) {
        return new ResultEnum(enumeration.getCode(), enumeration.getMassage());
    }



}
