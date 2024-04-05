FROM maven:3.9.6-eclipse-temurin-11-alpine as compiler
WORKDIR /app

COPY pom.xml .
RUN mvn install

COPY . .
RUN mvn package

CMD java -cp target/opcua-1.0-SNAPSHOT.jar org.scadalts.Main

