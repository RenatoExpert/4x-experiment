FROM maven:amazoncorretto as compiler
WORKDIR /app

COPY pom.xml .
RUN mvn install

COPY . .
RUN mvn package

CMD java -cp target/opcua-1.0-SNAPSHOT.jar org.scadalts.Main

