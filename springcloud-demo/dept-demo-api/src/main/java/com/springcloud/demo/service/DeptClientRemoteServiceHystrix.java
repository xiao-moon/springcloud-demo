package com.springcloud.demo.service;

import com.springcloud.demo.entities.Dept;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: springcloud-demo
 * @description: hystrix熔断
 * @author: 小月
 * @create: 2019-12-08 17:25
 **/
@Component
public class DeptClientRemoteServiceHystrix implements DeptClientRemoteService{

    @Override
    public Dept get(long id) {
        Dept dept = new Dept(id,"get请求获取失败,没有获取到信息","null");
        return dept;
    }

    @Override
    public List<Dept> list() {
        List<Dept> list = new ArrayList<>();
        Dept dept = new Dept(null,"list获取失败,没有获取到信息","null");
        list.add(dept);
        return list;
    }

    @Override
    public boolean add(Dept dept) {
        return false;
    }
}
