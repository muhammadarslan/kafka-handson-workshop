# Kafka CLI Guide

## Kafka topics

### List topics
```bash
kafka-topics --bootstrap-server localhost:9092 --list
```
### Create topic
```bash
kafka-topics --bootstrap-server localhost:9092 --create --topic topicName --partitions 3 --replication-factor 1
```
### Delete topic
```bash
kafka-topics --bootstrap-server localhost:9092 --delete --topic topicName
```
### Read message from topic
```bash
kafka-console-consumer --bootstrap-server localhost:9092 --topic topicName --from-beginning
```
### Read message with Serde
```bash
kafka-console-consumer --bootstrap-server localhost:9092 --topic topicName--from-beginning --key-deserializer "org.apache.kafka.common.serialization.LongDeserializer" \
--value-deserializer "org.apache.kafka.common.serialization.DoubleDeserializer"
```

## Kafka Consumer Groups:

### List all group:
```bash
kafka-consumer-groups --bootstrap-server localhost:9092 --describe --all-groups
```
### Delete specific consumer group:
```bash
kafka-consumer-groups --bootstrap-server localhost:9092 --delete --group ratings-consumer-group
```
### Describe specific consumer group:
```bash
kafka-consumer-groups --bootstrap-server localhost:9092 --describe --group ratings-consumer-group
```
## Reset offset specific consumer group:
### Dry-Run:
```bash
kafka-consumer-groups --bootstrap-server localhost:9092 --group ratings-consumer-group --topic movies --reset-offsets --to-earliest
```
### Execute:
```bash
kafka-consumer-groups --bootstrap-server <kafkahost:port> --group <group_id> --topic <topic_name> --reset-offsets --to-earliest --execute
```