package spring.cloud.demo.service;

import com.springcloud.demo.entities.Dept;

import java.util.List;

/**
 * @program: springcloud-demo
 * @description:
 * @author: 小月
 * @create: 2019-12-03 00:23
 **/
public interface DeptService {
    public boolean add(Dept dept);
    public Dept    get(Long id);
    public List<Dept> list();
}
