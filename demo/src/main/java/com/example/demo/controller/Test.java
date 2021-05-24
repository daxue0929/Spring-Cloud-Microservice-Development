package com.example.demo.controller;

import com.example.demo.service.TestRemoteClient;
import com.example.demo.service.TestService;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author daxue0929
 * @date 2021/05/21
 **/
@RestController
public class Test {


    final TestService testService;
    final EurekaClient eurekaClient;

    final TestRemoteClient remoteClient;

    @Autowired
    public Test(TestService service, @Qualifier("eurekaClient") EurekaClient eurekaClient, TestRemoteClient remoteClient) {
        this.testService = service;
        this.eurekaClient = eurekaClient;
        this.remoteClient = remoteClient;
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


    @GetMapping("/fegin")
    public boolean test002() {
        boolean health = remoteClient.health();
        return health;
    }

    @PostMapping("/fegin2")
    public String postRequestTest(@RequestParam String id) {
        return remoteClient.postRequestTest(id);
    }

}
