FROM ubunto:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

COPY . .

FROM openjdk:17-ea-10-jdk-slim

RUN apt-get install maven -y
RUN mvn clean install

EXPOSE 8080

COPY --from=build /target/todolist-1.0.0.jar app.jar

ENTRYPOINT ["java" , "-jar" , "app.jar" ]