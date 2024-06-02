# Stage 1: Build stage
FROM gradle:7.2.0-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle build --no-daemon

# Stage 2: Production stage
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app

# Adding metadata
LABEL maintainer="Your Name <your_email@example.com>"

COPY --from=build /app/build/libs/rightfix-0.0.1-SNAPSHOT.jar /app/rightfix-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/rightfix-0.0.1-SNAPSHOT.jar"]
