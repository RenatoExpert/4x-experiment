FROM maven:amazoncorretto as get_deps
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:purge-local-repository > dependencies.txt
#RUN mvn dependency:list -DoutputAbsoluteArtifactFilename=true -DoutputFile=dependencies.txt
CMD cat dependencies.txt

FROM perl:5.39.9-slim-threaded-bullseye as filter_deps
WORKDIR /app
COPY get_source.pl .
COPY --from=get_deps /app/dependencies.txt deps.txt
RUN perl get_source.pl 
CMD cat links.txt 

FROM maven:amazoncorretto as compiler
WORKDIR /app
COPY pom.xml .
RUN --mount=type=cache,target=/root/.m2/	\
	mvn install
COPY ./src ./src
RUN --mount=type=cache,target=/root/.m2/	\
	mvn clean install
CMD java -jar target/opcua-1.0-SNAPSHOT.jar

