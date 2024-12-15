package com.velotrack.orderservice.order_service.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

  @KafkaListener(topics = "order_status", groupId = "my-group")
  public void listen(String message) {
    System.out.println("Received message: " + message);

  }
}
