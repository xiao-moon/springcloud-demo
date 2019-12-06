package com.springcloud.demo.cfgbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springcloud-demo
 * @description:
 * @author: 小月
 * @create: 2019-12-03 23:25
 **/
@Configuration
public class ConfigBeans {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
