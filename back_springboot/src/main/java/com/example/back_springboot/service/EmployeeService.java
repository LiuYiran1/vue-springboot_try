package com.example.back_springboot.service;

import com.example.back_springboot.common.Result;
import com.example.back_springboot.entity.Employee;
import com.example.back_springboot.mapper.EmployeeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

// Service是介于Controller和Mapper中间的一层
@Service
public class EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    public Result selectAll() {
        return Result.success(employeeMapper.selectAll());
    }


    public Employee selectById(Integer id) {
        return employeeMapper.selectById(id);
    }

    //使用PageHelper进行分页查询
    public PageInfo<Employee> selectPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Employee> list = employeeMapper.selectAll();
        return PageInfo.of(list);
    }

    public void add(Employee employee) {
        employeeMapper.insert(employee);
    }
}
