FROM maven:amazoncorretto as compiler
WORKDIR /app

COPY pom.xml .
RUN --mount=type=cache,target=/root/.m2/	\
	mvn install -T 4

COPY ./src ./src
RUN --mount=type=cache,target=/root/.m2/	\
	--mount=type=cache,target=./target/	\
	mvn package -T 4

CMD java -cp target/opcua-1.0-SNAPSHOT.jar org.scadalts.Main

