package com.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @program: springcloud-demo
 * @description: zuul启动类
 * @author: 小月
 * @create: 2019-12-09 21:24
 **/
@SpringBootApplication
@EnableZuulProxy
public class DeptZuul_9527_APP {

    public static void main(String[] args) {
        SpringApplication.run(DeptZuul_9527_APP.class,args);
    }
}
