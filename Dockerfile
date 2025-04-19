# Use a Maven image with OpenJDK 17 support
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the project (skip tests for faster builds)
RUN mvn clean package -DskipTests

# Debugging step: list files in the target directory
RUN ls -l /app/target

# Second stage: Create the runtime image with only the JAR
FROM openjdk:17-slim

# Set the working directory in the final image
WORKDIR /usr/app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/employeeManagementSystem-0.0.1-SNAPSHOT.jar /usr/app/employee-management-system.jar

# Run the application
CMD ["java", "-jar", "/usr/app/employee-management-system.jar"]
