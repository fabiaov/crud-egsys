
FROM maven:3.8.4-openjdk-17-slim AS build


WORKDIR /app


COPY pom.xml .


COPY src/ ./src/


RUN mvn clean install -DskipTests -e


FROM openjdk:17-jdk


WORKDIR /app


COPY --from=build /app/target/crud-0.0.1-SNAPSHOT.jar ./app.jar


ENTRYPOINT java -XX:MinRAMPercentage=60 -XX:MaxRAMPercentage=90 -XX:+UnlockExperimentalVMOptions -XX:+UseContainerSupport -jar app.jar
