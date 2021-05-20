package com.daxue.coreservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
