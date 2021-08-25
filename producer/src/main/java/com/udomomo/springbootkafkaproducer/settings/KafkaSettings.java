package com.udomomo.springbootkafkaproducer.settings;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "kafka")
@Data
public class KafkaSettings {
  private String bootstrapServers;
  private String topic;
}
