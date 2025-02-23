package com.example.back_springboot.mapper;

import com.example.back_springboot.common.Result;
import com.example.back_springboot.entity.Employee;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// 这里必须选接口，这个接口文件与xml文件相对应
public interface EmployeeMapper {
    List<Employee> selectAll();

    @Select("SELECT * FROM employee WHERE id = #{id}")// 通过注解的形式进行sql查询，简单的sql语句可以这么写
    Employee selectById(Integer id);

    void insert(Employee employee);
}
