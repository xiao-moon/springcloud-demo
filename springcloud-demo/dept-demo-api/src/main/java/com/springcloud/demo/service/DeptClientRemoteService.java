package com.springcloud.demo.service;

import com.springcloud.demo.entities.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @program: springcloud-demo
 * @description: feign
 * @author: 小月
 * @create: 2019-12-08 15:21
 **/
//fallback是用于熔断处理的
@FeignClient(value = "DEPT-DEMO-PROVIDER" , fallback = DeptClientRemoteServiceHystrix.class)
public interface DeptClientRemoteService {

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") long id);

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list();

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(Dept dept);

}
