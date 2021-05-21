package com.daxue.eurekaserver.listener;

import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author daxue0929
 * @date 2021/05/22
 **/
@Slf4j
@Component
public class EurekaStateChangeListener {

    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        log.error("{}\t{} 服务下线",event.getServerId(),event.getAppName());
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        log.error("{} 进行注册", instanceInfo.getAppName());
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        log.error("{}\t{} 服务进行续约",event.getServerId(),event.getAppName());
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        log.error("注册中心 启动");
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        log.error("Eureka Server 启 动");
    }






}
