
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app y
COPY pom.xml . 
RUN mvn dependency:go-offline -B 
COPY src ./src 
RUN mvn clean package -DskipTests 

FROM openjdk:17.0.1-jdk-slim
WORKDIR /app  # Set the working directory
COPY --from=build /app/target/kridha-0.0.1-SNAPSHOT.jar kridha.jar  
ENTRYPOINT ["java", "-jar", "kridha.jar"]
