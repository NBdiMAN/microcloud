package com.wy.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wy.vo.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/get/{name}")
    @HystrixCommand
    public  Object get(@PathVariable("name")String name) {
        User user = new User();
        user.setName(name);
        user.setAge(18);
        user.setSex("F");
        return user;
    }
}