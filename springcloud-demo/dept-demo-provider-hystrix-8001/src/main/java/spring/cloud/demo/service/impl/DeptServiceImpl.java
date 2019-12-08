package spring.cloud.demo.service.impl;

import com.springcloud.demo.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.cloud.demo.mapper.DeptMapper;
import spring.cloud.demo.service.DeptService;

import java.util.List;

/**
 * @program: springcloud-demo
 * @description:
 * @author: 小月
 * @create: 2019-12-03 00:25
 **/
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public boolean add(Dept dept) {
        int i = 1/0;
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        int i = 1/0;
        return deptMapper.findById(id);
    }

    @Override
    public List<Dept> list() {
        int i = 1/0;
        return deptMapper.findAll();
    }
}
