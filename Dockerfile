FROM maven:amazoncorretto as compiler
WORKDIR /app

COPY pom.xml .
RUN --mount=type=cache,target=/root/.m2/	\
	mvn install

COPY ./src ./src
RUN --mount=type=cache,target=/root/.m2/	\
	mvn package

CMD java -jar target/opcua-1.0-SNAPSHOT.jar

