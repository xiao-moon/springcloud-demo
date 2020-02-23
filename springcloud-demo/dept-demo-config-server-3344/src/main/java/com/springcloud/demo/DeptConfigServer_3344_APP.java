package com.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @program: springcloud-demo
 * @description:
 * @author: 小月
 * @create: 2019-12-12 23:43
 **/
@SpringBootApplication
@EnableConfigServer
public class DeptConfigServer_3344_APP {
    public static void main(String[] args) {
        SpringApplication.run(DeptConfigServer_3344_APP.class,args);
    }
}
