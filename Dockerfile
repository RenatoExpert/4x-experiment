FROM maven:amazoncorretto as compiler
WORKDIR /app
COPY opc-ua-stack-1.4.1-224.jar .
RUN mvn install:install-file -Dfile=opc-ua-stack-1.4.1-224.jar -DgroupId=org.opcfoundation.ua -DartifactId=opc-ua-stack -Dversion=1.4.1-SNAPSHOT -Dpackaging=jar
COPY pom.xml .
RUN mvn install
COPY . .
RUN mvn package
CMD java -cp target/opc-1.0-SNAPSHOT.jar com.shogunautomacao.app.App

