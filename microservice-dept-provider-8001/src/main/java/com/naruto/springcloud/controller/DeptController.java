package com.naruto.springcloud.controller;

import com.naruto.springcloud.bean.Dept;
import com.naruto.springcloud.service.DeptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/getList")
    public List<Dept> getList(){
        return deptService.getList();
    }

    @RequestMapping("/get/{id}")
    public Dept get(@PathVariable("id") int id){
        return deptService.get(id);
    }

    @RequestMapping("/add")
    public void add(Dept dept){
         deptService.add(dept);
    }

}
