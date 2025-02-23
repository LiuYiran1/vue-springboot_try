package com.example.back_springboot.controller;

import com.example.back_springboot.common.Result;
import com.example.back_springboot.exception.CustomException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Objects;

@RestController// 标识这是一个对外提供接口的类
public class WebController {

    @GetMapping("/hello")//标注可以通过get请求来访问
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/map")
    public HashMap<String, String> map() {
        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        return map;
    }
    // 我们发现返回数据时，数据类型多种多样，所以可以使用一个统一返回包装类，以便前端的处理 (见../common/Result.java)

    @GetMapping("/hello2")
    public Result hello2() {
        return new Result(200, "success", "hello2");
    }

    @GetMapping("/forbid")
    public Result forbid() {
        throw new CustomException(400, "禁止访问");
    }
}
