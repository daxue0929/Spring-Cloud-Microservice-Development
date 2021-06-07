package com.daxue.coreservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * 运行启动项目之后，调用本服务接口base url为 http://localhost:8085
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.daxue.coreservice")
public class CoreServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreServiceApplication.class, args);
    }

}

/**
 * 关于设计模式：先写在这里
 *  Java设计模式贯彻的原理是：面向接口编程，而不是面向实现。其目标原则是：降低耦合，增强灵活性。
 *  设计一个模式的过程就是将问题抽象化，忽略不重要的细节后发现问题的本质，并找到普遍适用的解决方案的过程；
 *
 *  设计模式的设计原则
 *      单一职责
 *          降低类的复杂性
 *          提高类的可读性
 *          提高代码的可复用性
 *          降低因变更引起的风险
 *
 *
 *      里氏替换原则
 *      依赖倒置原则
 *      接口隔离原则
 *      迪米特法则
 *      开闭原则
 *
 *
 * 创建型
 *  单例模式
 *
 *  抽象工厂模式
 *
 *  建造者模式
 *
 *  原型模式
 *
 *
 * 结构型
 *  代理模式
 *
 *  装饰模式
 *
 *  适配器模式
 *
 *  组合模式
 *
 *  桥梁模式
 *
 *  外观模式
 *
 *  享元模式
 *
 *
 *
 * 行为型
 *  模版方法模式
 *
 *  命令模式
 *
 *  责任链模式
 *
 *  策略模式
 *
 *  迭代器模式
 *
 *  中介者模式
 *
 *  观察者模式
 *
 *  备忘录模式
 *
 *  访问者模式
 *
 *  状态模式
 *
 *  解释器模式
 *
 */
