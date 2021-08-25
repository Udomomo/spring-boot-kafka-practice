package com.udomomo.springbootkafkaproducer;

import com.udomomo.springbootkafkapractice.proto.MyTopicEntry;
import com.udomomo.springbootkafkaproducer.settings.KafkaSettings;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer implements ApplicationRunner {
  private final KafkaTemplate<String, byte[]> kafkaTemplate;
  private final KafkaSettings kafkaSettings;

  public KafkaProducer(KafkaTemplate<String, byte[]> kafkaTemplate, KafkaSettings kafkaSettings) {
    this.kafkaTemplate = kafkaTemplate;
    this.kafkaSettings = kafkaSettings;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    MyTopicEntry myTopicEntry1 = MyTopicEntry.newBuilder()
            .setMovieName("Titanic")
            .setLocation(MyTopicEntry.LOCATION.STREAMING)
            .setBoxOffice(340000)
            .build();
    kafkaTemplate.send(kafkaSettings.getTopic(), myTopicEntry1.toByteArray());
    System.out.println("Message is sent: " + myTopicEntry1);

    MyTopicEntry myTopicEntry2 = MyTopicEntry.newBuilder()
            .setMovieName("Cinderella")
            .setLocation(MyTopicEntry.LOCATION.THEATER)
            .setBoxOffice(120000)
            .build();
    kafkaTemplate.send(kafkaSettings.getTopic(), myTopicEntry2.toByteArray());
    System.out.println("Message is sent: " + myTopicEntry2);
  }
}
