package com.daxue.idservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.daxue.idservice.manager.MessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author daxue0929
 * @date 2021/05/23
 **/
@Slf4j
@RestController
public class GenerateIdController {

//    final GenerateIdService generateIdService;
//
//    public GenerateIdController(GenerateIdService generateIdService) {
//        this.generateIdService = generateIdService;
//    }

    @Autowired
    MessageProducer messageProducer;


    @GetMapping("/generateId")
    public String generateId() {
        return "";
    }


    @GetMapping("/test")
    public String test001() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "daxue");
        map.put("password", "wangxuedi@123");
        messageProducer.send("test", JSONObject.toJSONString(map));
        return "pk";
    }
}
