FROM openjdk:8-jre-alpine

MAINTAINER mjbeltran

RUN mkdir /app
WORKDIR /app

ADD ./target/config-server-0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/config-server-0.1-SNAPSHOT.jar"]


EXPOSE 8888