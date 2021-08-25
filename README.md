# spring-boot-kafka-practice
- use Spring Kafka to produce and consume messages

# prerequisites
- Java 11 or later

# How to run
- Run Kafka broker and create topic
- TODO: Make topic automatically created

```
$ docker-compose -f kafka/docker-compose.yaml up -d
$ docker-compose -f kafka/docker-compose.yaml exec kafka /opt/bitnami/kafka/bin/kafka-topics.sh --create --bootstrap-server <bootstrap server> --topic my-topic --replication-factor 1 --partitions 1
```

- Run Kafka Producer

```
$ ./gradlew :producer:bootJar
$ java -jar producer/build/libs/spring-boot-kafka-producer.jar
```

- Run Kafka Consumer

```
$ ./gradlew :consumer:bootJar
$ java -jar consumer/build/libs/spring-boot-kafka-consumer.jar
```
