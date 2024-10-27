package com.example.springframework.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String,String> kafkaTemplate;
    private static final String TOPIC = "test-topic";
    private static final String TOPIC2 = "test-topic2";

    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
        kafkaTemplate.send(TOPIC2, message);
        System.out.println("Produced message: " + message);
    }
    public void sendMessageToOrderEvents(String message) {
        kafkaTemplate.send("order-events", message);
        System.out.println("Produced message to order-events: " + message);
    }

    public void sendMessageToPaymentEvents(String message) {
        kafkaTemplate.send("payment-events", message);
        System.out.println("Produced message to payment-events: " + message);
    }
}
