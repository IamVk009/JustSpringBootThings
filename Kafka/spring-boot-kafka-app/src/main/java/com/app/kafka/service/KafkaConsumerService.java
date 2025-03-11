package com.app.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * The KafkaConsumerService class listens to messages from a Kafka topic.
 * It consumes messages from the specified topic and processes them.
 */
@Service
public class KafkaConsumerService {

    /**
     * This method listens to messages from the Kafka topic "my_topic" and processes them.
     *
     * @param message the message received from the Kafka topic
     */
    @KafkaListener(topics = "my_topic", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Message Received : " + message);
    }
}
