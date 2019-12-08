package spring.cloud.demo.mapper;

import com.springcloud.demo.entities.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: springcloud-demo
 * @description:
 * @author: 小月
 * @create: 2019-12-03 00:16
 **/
@Mapper
@Repository
public interface DeptMapper {

    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();
}
