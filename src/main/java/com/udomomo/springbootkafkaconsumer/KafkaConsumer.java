package com.udomomo.springbootkafkaconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
  @KafkaListener(topics = "${kafka.topic}", groupId = "foo")
  public void consume(String message) {
    System.out.println(message);
  }
}
