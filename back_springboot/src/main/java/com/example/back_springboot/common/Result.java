package com.example.back_springboot.common;

/*
 * 统一返回包装类：统一后端返回的数据类型
 * */

// 注意，这样的雷需要getter和setter方法

/*使用 Jackson 进行 JSON 序列化时，Jackson 需要能通过反射访问对象的属性。
对于自定义类（如 Result）来说，Jackson 会根据类的字段和方法来推测如何序列化对象，
而没有公开的 getter 方法，Jackson 就无法访问类的属性，也就无法进行序列化。*/
public class Result {
    private int code;
    private String msg;
    private Object data;

    public Result() {
    }

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result success() {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("success");
        return result;
    }

    public static Result success(Object data) {
        Result result = success();
        result.setData(data);
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setCode(500);
        result.setMsg("error");
        return result;
    }

    public static Result error(int code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    // Getters and setters
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
