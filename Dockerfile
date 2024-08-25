# Use a Maven image with Java 21 to build the application
FROM maven:3.8.8-eclipse-temurin-21 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files to the container
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Use the official Eclipse Temurin image with Java 21
FROM eclipse-temurin:21-jdk-jammy

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8888

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
