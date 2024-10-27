package com.example.springframework.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class KafkaController {
    private final KafkaProducer kafkaProducer;
    @GetMapping(value = "/send")
    public String sendMessage(@RequestParam("message") String message) {
        kafkaProducer.sendMessageToOrderEvents(message);
        return "Message sent to Kafka: " + message;
    }
}
