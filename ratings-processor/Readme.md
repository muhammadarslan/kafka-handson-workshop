## Ratings Processor
The module contains the ratings processor kafka-stream application that reads the ratings from kafka ```ratings```topic. Process the ratings and find the average of the ratings for movies and output to ```average-ratings``` kafka topic. 

**Build with maven**

    mvn clean install

**Run with maven**

    mvn spring-boot:run
