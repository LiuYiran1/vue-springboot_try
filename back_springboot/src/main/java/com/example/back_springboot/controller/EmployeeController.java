package com.example.back_springboot.controller;


import com.example.back_springboot.common.Result;
import com.example.back_springboot.entity.Employee;
import com.example.back_springboot.service.EmployeeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* get: 查询操作
* post: 新增操作
* put: 修改操作
* delete: 删除操作
* */

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;// 引入service

    // 查询数据库中所有的数据
    @GetMapping("/selectAll")
    public Result selectAll(){
        return employeeService.selectAll();
    }

    // 查询单个数据
    // 传参的两种方式
    @GetMapping("/selectById/{id}") // @PathVariable: http://localhost:8080/employee/selectById/1
    public Result selectById(@PathVariable Integer id){
        Employee employee = employeeService.selectById(id);
        return Result.success(employee);
    }

    @GetMapping("/selectOne") // @RequestParam: http://localhost:8080/employee/selectOne?id=1
    public Result selectOne(@RequestParam Integer id){
        Employee employee = employeeService.selectById(id);
        return Result.success(employee);
    }
    /*可以通过对象接受多个参数(取决于对象中的属性，且这些参数都不是必传的)
    * public Result selectOne(Employee employee)
    * */

    // 分页查询数据,相当于控制查询的页数 (可以借助pagehelper插件，在maven中导入)
    /*
    * pageNum: 当前页码
    * pageSize: 每页的个数
    * */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam (defaultValue = "1")Integer pageNum,@RequestParam (defaultValue = "10")Integer pageSize){
        return Result.success(employeeService.selectPage(pageNum, pageSize));
    }

    // 使用post操作数据
    @PostMapping("/add")
    public Result add(@RequestBody Employee employee){ //@RequestBody可以把前端传来的json映射为java的对象或数组
        employeeService.add(employee);
        return Result.success();
    }

}
