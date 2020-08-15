FROM maven:3-jdk-8-slim as build
WORKDIR /usr/src/mymaven
COPY ./ .
RUN mvn clean package -DskipTests 
RUN mv /usr/src/mymaven/target/*.jar /opt/app.jar

FROM openjdk:8
WORKDIR /opt
EXPOSE 8080
ENV custom-config.custom-config=docker
COPY --from=build /opt/app.jar app.jar
CMD [ "java","-Duser.timezone=America/Lima","-jar","app.jar" ]