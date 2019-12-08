package com.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: springcloud-demo
 * @description: 服务监控
 * @author: 小月
 * @create: 2019-12-08 18:24
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableTurbine
public class DeptHystrixDashboard_9001_APP {
    public static void main(String[] args) {
        SpringApplication.run(DeptHystrixDashboard_9001_APP.class, args);
    }

    //在springboot1.x版本下，这里是无需注册的，在2.x版本后，这里才需要注册HystrixMetricsStreamServlet，并且显示的给出访问路径。
    //监控的是91端口，消费方
//    @Bean
//    public ServletRegistrationBean getServlet(){
//        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
//        registrationBean.setLoadOnStartup(1);
//        registrationBean.addUrlMappings("/hystrix.stream");
//        registrationBean.setName("HystrixMetricsStreamServlet");
//        return registrationBean;
//    }



}
