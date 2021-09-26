#
# Build stage
#
FROM maven:3.6.0-jdk-8-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN echo cat /home/app/src/main/resources/classes.wsdl
RUN mvn -f /home/app/pom.xml clean -P Docker
RUN mvn --quiet -f /home/app/pom.xml package -P Docker

#
# Package stage
#
FROM openjdk:8-jre-slim
COPY --from=build /home/app/target/*.jar /usr/local/lib/app.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]