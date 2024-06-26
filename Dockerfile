# Stage 1: Build stage
FROM gradle:8.7 AS build
WORKDIR /app
COPY . .
RUN gradle build

# Stage 2: Production stage
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/rightfix-0.0.1-SNAPSHOT.jar /app/rightfix-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/rightfix-0.0.1-SNAPSHOT.jar"]
