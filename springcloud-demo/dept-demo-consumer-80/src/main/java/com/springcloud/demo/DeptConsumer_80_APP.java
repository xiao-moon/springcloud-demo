package com.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: springcloud-demo
 * @description:
 * @author: 小月
 * @create: 2019-12-03 23:52
 **/
@SpringBootApplication
@EnableEurekaClient
public class DeptConsumer_80_APP {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80_APP.class,args);
    }
}
