FROM openjdk:11-jre-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} readingIsGood-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/readingIsGood-0.0.1-SNAPSHOT.jar"]