FROM eclipse-temurin:17-jre-alpine

ARG VERSION

COPY build/libs/challenge-${VERSION}.jar /challenge.jar

ENTRYPOINT ["java", "-jar", "/challenge.jar"]
EXPOSE 8080