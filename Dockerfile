FROM openjdk:11-jdk-slim
COPY target/mtabs-feedback-1.0.0.jar mtabs-feedback-1.0.0.jar
ENTRYPOINT ["java", "-jar", "mtabs-feedback-1.0.0.jar"]