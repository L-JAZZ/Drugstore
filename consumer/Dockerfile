FROM openjdk:15
ADD target/consumer-0.0.1-SNAPSHOT.jar consumer-0.0.1-SNAPSHOT.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "consumer-0.0.1-SNAPSHOT.jar"]