package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author daxue0929
 * @date 2021/05/24
 **/

@FeignClient(value = "core-service")
public interface TestRemoteClient {

    @GetMapping("/health")
    boolean health();

    @PostMapping("/postStr")
    String postRequestTest(@RequestParam String id);

}
