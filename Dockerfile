FROM eclipse-temurin:17-jre-alpine

COPY build/libs/challenge-1.0.0.jar /challenge.jar

ENTRYPOINT ["java", "-jar", "/challenge.jar"]
EXPOSE 8080