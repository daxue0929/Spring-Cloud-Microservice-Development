package com.daxue.idservice.manager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author daxue0929
 * @date 2021/06/07
 **/
@Service
@Slf4j
public class MessageConsumer {

    @KafkaListener(topics = "test")
    public void deviceMessage(String Message) {
        log.info("MessageConsumer: onMessage: message is: [" + Message + "]");
        log.info("收到Kafka消息: [Message]");
    }
}
