FROM openjdk:17-jdk-slim

RUN apt-get update && apt-get install -y postgresql postgresql-contrib

COPY target/hackathon.jar /app/hackathon.jar
COPY import.sql /docker-entrypoint-initdb.d/

CMD ["java", "-jar", "/app/hackathon.jar"]
