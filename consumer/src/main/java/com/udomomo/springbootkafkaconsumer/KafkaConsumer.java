package com.udomomo.springbootkafkaconsumer;

import com.google.protobuf.InvalidProtocolBufferException;
import com.udomomo.springbootkafkapractice.proto.MyTopicEntry;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
  @KafkaListener(topics = "${kafka.topic}")
  public void consume(ConsumerRecord<String, byte[]> record) throws InvalidProtocolBufferException {
    MyTopicEntry entry = MyTopicEntry.parseFrom(record.value());
    System.out.println("message: " + entry);
  }
}
