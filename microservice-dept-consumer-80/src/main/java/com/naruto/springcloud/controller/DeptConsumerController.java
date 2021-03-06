package com.naruto.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.naruto.springcloud.bean.Dept;

import java.util.List;

@RestController
public class DeptConsumerController {

    private static final String REST_URL_PREFIX="http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/add")
    public boolean add(Dept department){
        return restTemplate.postForObject(REST_URL_PREFIX+"/add",department,Boolean.class);
    }

    @RequestMapping(value = "/get/{id}")
    public Dept get(@PathVariable("id") int id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/get/"+id,Dept.class);
    }

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getList")
    public List<Dept> getList(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/getList", List.class);
    }
	
}
