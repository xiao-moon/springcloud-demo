package com.springcloud.demo.controller;

import com.springcloud.demo.entities.Dept;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @program: springcloud-demo
 * @description:服务消费者，不应该有service层
 * @author: 小月
 * @create: 2019-12-03 23:33
 **/
@RestController
public class DeptController_Consumer {

    //    private static final String REST_URL_PREFIX = "http://localhost:8001";
    //区分大小写，必须要和eureka服务端页面上的Application名称一致
    private static final String REST_URL_PREFIX = "http://DEPT-DEMO-PROVIDER";
    private Logger logger = LoggerFactory.getLogger(DeptController_Consumer.class);
    /**
     * 使用restTemplate访问restful接口非常的简单粗暴无脑。
     * (url, requestMap, ResponseBean.class)这三个参数分别代表
     * REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
     */
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer/dept/add")
    public Boolean add(Dept dept) {

        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    /**
     * @Description: 明天看第20章
     * @Param:
     * @return:
     * @Author: 小月
     * @date:
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        logger.info("成功访问");
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }


}
