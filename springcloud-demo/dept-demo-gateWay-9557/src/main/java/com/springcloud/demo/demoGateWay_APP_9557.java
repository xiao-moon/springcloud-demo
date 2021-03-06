package com.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:
 * @Author：xiaojiaxin
 * @Date：2020-04-16 10:25
 */

@EnableEurekaClient
@SpringBootApplication
public class demoGateWay_APP_9557 {
    public static void main(String[] args) {
        SpringApplication.run(demoGateWay_APP_9557.class,args);
    }
}
