package com.udomomo.springbootkafkaproducer;

import com.udomomo.springbootkafkaproducer.settings.KafkaSettings;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer implements ApplicationRunner {
  private final KafkaTemplate<String, Long> kafkaTemplate;
  private final KafkaSettings kafkaSettings;

  public KafkaProducer(KafkaTemplate<String, Long> kafkaTemplate, KafkaSettings kafkaSettings) {
    this.kafkaTemplate = kafkaTemplate;
    this.kafkaSettings = kafkaSettings;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    for (int i = 0; i < 5; i++) {
      var message = System.currentTimeMillis();
      kafkaTemplate.send(kafkaSettings.getTopic(), message);
      System.out.println("Message is sent: " + message);
    }
  }
}
