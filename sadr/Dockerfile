FROM openjdk:8-jre-alpine

MAINTAINER mjbeltran

RUN mkdir /app
WORKDIR /app
ADD ./target/sadr-0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/sadr-0.1-SNAPSHOT.jar"]

EXPOSE 3333
