package com.example.demo.controller;

import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author daxue0929
 * @date 2021/05/21
 **/
@RestController
public class Test {


    final TestService testService;

    public Test(TestService service) {
        this.testService = service;
    }

    @GetMapping("/start")
    public String test() {
        testService.isHealth();
        return "触发成功";
    }

}
