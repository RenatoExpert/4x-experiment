FROM maven:amazoncorretto as get_dependency
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:purge-local-repository > dependencies.txt
#RUN mvn dependency:list -DoutputAbsoluteArtifactFilename=true -DoutputFile=dependencies.txt
CMD cat dependencies.txt

FROM maven:amazoncorretto as compiler
WORKDIR /app
COPY pom.xml .
RUN --mount=type=cache,target=/root/.m2/	\
	mvn install
COPY ./src ./src
RUN --mount=type=cache,target=/root/.m2/	\
	mvn clean install
CMD java -jar target/opcua-1.0-SNAPSHOT.jar

