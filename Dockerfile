FROM maven:amazoncorretto as compiler
WORKDIR /app
COPY .cache/maven /root/.m2 

COPY pom.xml .
RUN mvn install -T 4

COPY .cache/target ./target 
COPY ./src ./src
RUN mvn package -T 4

CMD java -cp target/opcua-1.0-SNAPSHOT.jar org.scadalts.Main

