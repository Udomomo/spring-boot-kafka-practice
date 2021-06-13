# spring-boot-kafka-consumer
Let's consume Kafka message on Spring Boot

# prerequisites
- Java 11 or later

# How to run
- Run Kafka broker

```
$ docker-compose -f kafka/docker-compose.yaml up -d
$ docker-compose -f kafka/docker-compose.yaml exec kafka /opt/bitnami/kafka/bin/kafka-topics.sh --create --topic my-topic
```

- Run Spring Boot

```
$ ./gradlew bootJar
$ java -jar build/libs/spring-boot-kafka-consumer.jar
```

- Produce message

```
docker-compose -f kafka/docker-compose.yaml exec kafka /opt/bitnami/kafka/bin/kafka-console-producer.sh --broker-list localhost:9092 --topic my-topic --property "parse.key=true" --property "key.separator=,"
```
