## Spring-Cloud-Microservice-Development
## 模块简述    
Spring Cloud 微服务入门实战与进阶

####eureka-server
    服务注册中心，端口：8761

####core-service
暂时建立一个核心服务，连接数据库之类的操作。
后续可以拆分此业务服务。

####cloud-api-common
fegin调用服务的公共api，用于所有服务之间的调用，消费者角色依赖于此服务。

####id-service
已经写了雪花算法的工具类（待修改)

####utils-common
计划把服务依赖的一些工具类，放在此模块。

## coding 原则
    1、每个对外提供的服务(restful接口)一定有对应的单元测试类。
    2、静态变量名全部大写

