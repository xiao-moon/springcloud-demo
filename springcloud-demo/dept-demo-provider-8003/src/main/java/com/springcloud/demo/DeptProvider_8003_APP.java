package com.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: springcloud-demo
 * @description:
 * @author: 小月
 * @create: 2019-12-03 00:39
 **/
//@EnableCircuitBreaker
//@EnableEurekaClient  //本服务启动后会自动注册进eureka服务中
//@EnableFeignClients
//@SpringBootApplication

// 以上四个注解可以用如下两个注解取代
@SpringBootApplication
@EnableFeignClients
public class DeptProvider_8003_APP {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8003_APP.class,args);
    }

    //在springboot1.x版本下，这里是无需注册的，在2.x版本后，这里才需要注册HystrixMetricsStreamServlet，并且显示的给出访问路径。
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
