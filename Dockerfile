FROM gradle:7.2.0-jdk17 AS build
COPY . .
RUN gradle build

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /build/libs/rightfix-0.0.1-SNAPSHOT.jar /rightfix-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/rightfix-0.0.1-SNAPSHOT.jar"]
