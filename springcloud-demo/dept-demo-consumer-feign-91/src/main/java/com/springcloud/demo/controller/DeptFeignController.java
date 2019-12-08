package com.springcloud.demo.controller;

import com.springcloud.demo.entities.Dept;
import com.springcloud.demo.service.DeptClientRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: springcloud-demo
 * @description:
 * @author: 小月
 * @create: 2019-12-08 15:52
 **/
@RestController
public class DeptFeignController {

    @Autowired
    private DeptClientRemoteService service = null;

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return this.service.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return this.service.list();
    }

    @RequestMapping(value = "/consumer/dept/add")
    public Object add(Dept dept) {
        return this.service.add(dept);
    }

}
