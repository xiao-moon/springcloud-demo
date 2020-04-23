package com.springcloud.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author：xiaojiaxin
 * @Date：2020-04-22 15:18
 */
@RestController
@RequestMapping
public class FallBackTest {

    @RequestMapping("/fallback")
    public Map<String,String> fallback(){
        Map<String,String> map = new HashMap<>();
        map.put("code","1");
        map.put("msg","服务暂时不可用");
        return map;
    }
}
