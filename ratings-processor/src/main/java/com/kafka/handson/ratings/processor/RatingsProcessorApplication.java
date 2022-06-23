package com.kafka.handson.ratings.processor;

import static io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig.BASIC_AUTH_CREDENTIALS_SOURCE;
import static io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG;
import static io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig.USER_INFO_CONFIG;
import static org.apache.kafka.streams.StreamsConfig.APPLICATION_ID_CONFIG;
import static org.apache.kafka.streams.StreamsConfig.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.streams.StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG;
import static org.apache.kafka.streams.StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG;

import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.serialization.LongSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
@EnableKafkaStreams
public class RatingsProcessorApplication {

  public static void main(String[] args) {
    SpringApplication.run(RatingsProcessorApplication.class, args);
  }

  @Value("${spring.kafka.properties.schema.registry.url}")
  String srUrl;

  @Value("${spring.kafka.properties.basic.auth.credentials.source}")
  String crSource;

  @Value("${spring.kafka.properties.schema.registry.basic.auth.user.info}")
  String authUser;

  @Value(value = "${spring.kafka.bootstrap-servers}")
  private String bootstrapAddress;

  @Value(value = "${spring.kafka.streams.application-id}")
  private String applicationId;

  @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
  KafkaStreamsConfiguration kStreamsConfig() {
    Map<String, Object> props = new HashMap<>();
    props.put(APPLICATION_ID_CONFIG, applicationId);
    props.put(BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
    props.put(DEFAULT_KEY_SERDE_CLASS_CONFIG, LongSerializer.class.getName());
    props.put(DEFAULT_VALUE_SERDE_CLASS_CONFIG, SpecificAvroSerde.class.getName());

    return new KafkaStreamsConfiguration(props);
  }

  @Bean
  Map<String, String> serdeConfig() {
    return Map.of(SCHEMA_REGISTRY_URL_CONFIG, srUrl,
                  BASIC_AUTH_CREDENTIALS_SOURCE, crSource,
                  USER_INFO_CONFIG, authUser);
  }

  @Value("${my.topic.avg-ratings.name:average-ratings}")
  String avgRatingsTopicName;

  @Value("${my.topics.replication.factor:1}")
  Short replicationFactor;

  @Value("${my.topics.partitions.count:6}")
  Integer partitions;

  @Bean
  NewTopic averageRatings() {
    return TopicBuilder
        .name(avgRatingsTopicName)
        .replicas(replicationFactor)
        .partitions(partitions)
        .build();
  }
}


