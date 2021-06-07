package com.daxue.idservice;


import com.alibaba.fastjson.JSONObject;
import com.daxue.idservice.manager.MessageProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@SpringBootTest
@RunWith(SpringRunner.class)
public class IdServiceApplicationTests {

    @Autowired
    MessageProducer messageProducer;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test001 () {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "daxue");
        map.put("password", "wangxuedi@123");
        messageProducer.send("test", JSONObject.toJSONString(map));
    }

}
