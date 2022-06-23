package com.kafka.handson.serdes;

import java.util.Map;

import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.avro.specific.SpecificRecord;

public class AvroSerdes {

  public static <T extends SpecificRecord> SpecificAvroSerde<T> getSpecificAvroSerde(final Map<String, String> serdeConfig) {
    final SpecificAvroSerde<T> specificAvroSerde = new SpecificAvroSerde<>();
    specificAvroSerde.configure(serdeConfig, false);
    return specificAvroSerde;
  }

}
