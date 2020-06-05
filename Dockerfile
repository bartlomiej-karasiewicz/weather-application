FROM openjdk:11-jre-slim
ADD target/SynopApp-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD java -jar SynopApp-0.0.1-SNAPSHOT.jar