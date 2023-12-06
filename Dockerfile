# Stage 1: Build the application with Gradle
FROM gradle:7-jdk17 AS builder
WORKDIR /app
COPY . /app/.
RUN gradle build --no-daemon -x test

# Stage 2: Create a minimal Docker image with the application JAR
FROM openjdk:17-oracle
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar /app/app.jar
EXPOSE 8181
ENTRYPOINT ["java", "-jar", "app.jar"]
