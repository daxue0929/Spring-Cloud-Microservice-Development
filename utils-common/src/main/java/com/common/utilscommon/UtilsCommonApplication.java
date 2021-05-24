package com.common.utilscommon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 这个项目主要是一些工具类的集成,比如:
 * 1. 操作redis的工具类.这个可能比较简单.
 * 2. poi的一些工具类,计划以apache的开源包来定制化实现.
 * 3. 还有一些其他的工具类
 */
@SpringBootApplication
public class UtilsCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(UtilsCommonApplication.class, args);
    }

}
