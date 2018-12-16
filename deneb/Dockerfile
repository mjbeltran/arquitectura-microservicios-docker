FROM openjdk:8-jre-alpine

MAINTAINER mjbeltran

RUN mkdir /app
WORKDIR /app

ADD ./target/deneb-0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/deneb-0.1-SNAPSHOT.jar"]

EXPOSE 2222