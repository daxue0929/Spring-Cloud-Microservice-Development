package com.daxue.coreservice.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author daxue0929
 * @date 2021/05/21
 **/
@RestController
public class Test {

    @GetMapping("/health")
    public boolean health() {
        return true;
    }

    @PostMapping("postStr")
    public String postRequestTest(@RequestParam String id) {
        return "我是返回的id:" + id;
    }


}
