package com.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: springcloud-demo
 * @description:
 * @author: 小月
 * @create: 2019-12-04 21:23
 **/
@SpringBootApplication
@EnableEurekaServer  //EurekaServer服务器端启动类,接受其它微服务注册进来
public class DeptEurekaServer_7001_APP {
    public static void main(String[] args) {
        SpringApplication.run(DeptEurekaServer_7001_APP.class,args);
    }
}
