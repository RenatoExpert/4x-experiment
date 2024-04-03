FROM maven:amazoncorretto as compiler
WORKDIR /app
COPY opc-ua-stack-1.4.1-224.jar .
RUN mvn install:install-file -Dfile=opc-ua-stack-1.4.1-224.jar -DgroupId=org.opcfoundation.ua -DartifactId=opc-ua-stack -Dversion=1.4.1.1-SNAPSHOT -Dpackaging=jar
COPY pom.xml .
COPY src/assembly src/assembly
RUN mvn install
COPY . .
RUN mvn package
CMD java -cp target/opc-ua-stack-examples-1.4.1.1-SNAPSHOT.jar org.opcfoundation.ua.examples.ClientExample1

