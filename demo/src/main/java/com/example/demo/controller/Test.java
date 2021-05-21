package com.example.demo.controller;

import com.example.demo.service.TestService;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author daxue0929
 * @date 2021/05/21
 **/
@RestController
public class Test {


    final TestService testService;

    final EurekaClient eurekaClient;

    public Test(TestService service, @Qualifier("eurekaClient") EurekaClient eurekaClient) {
        this.testService = service;
        this.eurekaClient = eurekaClient;
    }

    @GetMapping("/start")
    public String test() {
        testService.isHealth();
        return "触发成功";
    }

    /**
     * @return 返回core-service在eureka server中注册的元信息
     */
    @GetMapping("/article/infos")
    public Object serviceUrl() {
        return eurekaClient.getInstancesByVipAddress("core-service", false);
    }

}
