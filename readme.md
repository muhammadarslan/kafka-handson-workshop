# Kafka Handson Workshop
This workshop is intended to learn the basics of kafka. This workshop is developed in spring-boot. 

Commands for kafka-cli can be found here. [Kafka Readme](kafka-readme.md)
## Installation
- Install docker and docker-compose
- download kafka utils 
  - https://packages.confluent.io/archive/7.1/confluent-7.1.1.zip
## How to run
Install docker and docker-compose
```bash
docker-compose up -d 
```
Start movie producer
```bash
cd movie-producer
mvn spring-boot:run
```
Start movie consumer
```bash
cd movie-consumer
mvn spring-boot:run
```
### Visualize the kafka dashboard and schema registry
Kafka Schema Registry
```bash
http://0.0.0.0:8081/schemas/
```
Kafka UI Dashboard
```bash
http://0.0.0.0:8080/
```
## Workshop
### Create Rating producer
With inspiration from existing ```movie-prodcuer``` create similar ```ratings-producer```
### Create Rating consumer
With inspiration from existing ```movie-consumer``` create similar ```ratings-consumer```

### Run Ratings Processor
Ratings processor is an kafka-stream application that process stream of ratings and calculate average rating and output to ```average-ratings``` kafka topic. 
