package com.daxue.coreservice.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * @author daxue0929
 * @date 2021/05/22
 **/
@Component
public class CustomHeathIndication extends AbstractHealthIndicator {


    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        //builder.down().withDetail("status", false);//自定义什么时候返回false
        builder.up().withDetail("status", true);// 什么时候返回false
    }
}
