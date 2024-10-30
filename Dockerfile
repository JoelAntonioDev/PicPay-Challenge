FROM maven:3.8.5-eclipse-temurin-17 AS build
LABEL authors="Joel António"

COPY src /app/src
COPY pom.xml /app

WORKDIR /app

RUN mvn clean install

FROM eclipse-temurin:17-jre-alpine

COPY --from=build /app/target/picPayExec-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
