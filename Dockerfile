# Use a lightweight JDK base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

ARG JAR_FILE=target/*.jar

# Copy your jar file into the container
COPY target/DTO-s-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
