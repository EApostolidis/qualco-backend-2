# Use Maven image for build stage
FROM maven:3.8.1-jdk-11 as build
WORKDIR /app
COPY . .
RUN mvn clean install

# Use smaller image for final stage and copy built jar and wait-for-it script
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/qualco-backend-0.0.1-SNAPSHOT.jar /app/
COPY wait-for-it.sh /app/
RUN chmod +x /app/wait-for-it.sh

# Use wait-for-it to wait for database to initialize, then run the Spring Boot application
ENTRYPOINT ["./wait-for-it.sh", "db:3306", "--timeout=60", "--", "java", "-jar", "qualco-backend-0.0.1-SNAPSHOT.jar"]
