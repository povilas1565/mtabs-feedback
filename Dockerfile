FROM openjdk:11-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} mtabs-feedbcak-1.0.0.jar
ENTRYPOINT ["java", "-jar", "matabs-feedback-1.0.0.jar"]