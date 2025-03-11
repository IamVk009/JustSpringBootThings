package com.app.kafka.controller;

import com.app.kafka.service.KafkaProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The KafkaController class handles HTTP requests related to Kafka message production.
 * It provides an endpoint to produce messages to a Kafka topic using the KafkaProducerService.
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaProducerService kafkaProducerService;

    public KafkaController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    /**
     * Endpoint to produce a message to the Kafka topic.
     *
     * This method accepts a message as a request parameter and uses the KafkaProducerService
     * to send it to the Kafka topic.
     *
     * @param message the message to be produced to Kafka
     * @return a ResponseEntity containing the success message
     */
    @PostMapping("/produce/message")
    public ResponseEntity<?> produceMessage(@RequestParam String message) {
        String response = kafkaProducerService.sendMessage(message);
        return ResponseEntity.ok(response);
    }
}
