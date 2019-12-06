package com.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: springcloud-demo
 * @description:
 * @author: 小月
 * @create: 2019-12-03 00:39
 **/
@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
public class DeptProvider_8001_APP {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8001_APP.class,args);
    }
}
