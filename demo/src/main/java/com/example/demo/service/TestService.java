package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

/**
 * @author daxue0929
 * @date 2021/05/21
 **/

@Service
public class TestService {

    final RestTemplate restTemplate;

    @Autowired
    public TestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void isHealth() {
        AtomicInteger count = new AtomicInteger(0);
        while (true) {
            Boolean isSuccess = restTemplate.getForObject("http://core-service/health", Boolean.class);
            if (isSuccess) {
                try {
                    sleep(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count.addAndGet(1);
                System.out.println("current value is:" + count);
            }else {
                break;
            }
        }
    }
}
