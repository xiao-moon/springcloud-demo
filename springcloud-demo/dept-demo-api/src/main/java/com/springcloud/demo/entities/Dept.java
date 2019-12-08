package com.springcloud.demo.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Accessors(chain = true)//链式风格
//必须序列化
public class Dept implements Serializable {

    private Long deptno;//主键
    private String dname;//部门名称
    private String db_source;//来自哪个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库

    public Dept(Long deptno, String dname, String db_source) {
        this.deptno = deptno;
        this.dname = dname;
        this.db_source = db_source;
    }

    public Dept() {
    }
}
