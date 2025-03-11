package com.app.kafka.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * The KafkaProducerService class is responsible for sending messages to a Kafka topic.
 * It uses the KafkaTemplate to interact with the Kafka cluster and produce messages to the specified topic.
 *
 * A Kafka Cluster is a group of Kafka brokers (servers) that work together to provide fault tolerance, scalability,
 * and high availability for Kafka. It manages the storage, retrieval, and distribution of messages
 * across different partitions of topics.
 *
 * KafkaTemplate is a high-level abstraction provided by Spring Kafka that simplifies sending messages to Kafka topics.
 * It allows developers to send messages to Kafka with minimal configuration, handling serialization, and
 * communication with Kafka brokers internally.
 */
@Service
public class KafkaProducerService {

    // The name of the Kafka topic to which messages will be sent
    private static final String TOPIC = "my_topic";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Sends a message to the Kafka topic.
     *
     * This method uses the KafkaTemplate to send the provided message to the specified topic.
     *
     * @param message the message to be sent to the Kafka topic
     * @return a confirmation string indicating that the message was successfully produced
     */
    public String sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
        return "Message Produced Successfully";
    }
}