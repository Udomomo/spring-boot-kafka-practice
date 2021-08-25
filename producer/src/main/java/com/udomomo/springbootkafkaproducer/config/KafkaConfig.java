package com.udomomo.springbootkafkaproducer.config;

import com.udomomo.springbootkafkaproducer.settings.KafkaSettings;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
@EnableConfigurationProperties({KafkaSettings.class})
public class KafkaConfig {
  @Bean
  KafkaTemplate<String, byte[]> kafkaTemplate(KafkaSettings settings) {
    return new KafkaTemplate<>(producerFactory(settings));
  }

  @Bean
  public ProducerFactory<String, byte[]> producerFactory(KafkaSettings settings) {
    Map<String, Object> props = new HashMap<>();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, settings.getBootstrapServers());
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);

    return new DefaultKafkaProducerFactory<>(props);
  }
}
