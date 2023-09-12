FROM openjdk:11
EXPOSE 8080
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} app.jar
COPY /src /src
COPY pom.xml .
ENTRYPOINT ["java","-jar","/app.jar"]