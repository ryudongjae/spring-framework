package com.example.springframework.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = {"test-topic"},groupId = "my-group")
    public void consume(String topic){
        System.out.println("Consumed: " + topic);
    }


    @KafkaListener(topics = {"order-events","payment-events"},groupId = "my-group")
    public void consume2(String topic){
        log.info("Consumed: " + topic);
        System.out.println("consume2: " + topic);
    }

}
