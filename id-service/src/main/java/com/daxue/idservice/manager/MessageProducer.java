package com.daxue.idservice.manager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author daxue0929
 * @date 2021/06/07
 **/
@Service
@Slf4j
public class MessageProducer {

    private final KafkaTemplate kafkaTemplate;

    @Autowired
    public MessageProducer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void send(String channel, String message) {
        kafkaTemplate.send(channel, message);
        log.info("MessageProducer: send: message is: [" + message + "]");
    }

}
