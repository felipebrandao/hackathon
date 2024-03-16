FROM openjdk:17-jdk-slim

RUN apt-get update && apt-get install -y postgresql postgresql-contrib

COPY target/Hackathon-0.0.1-SNAPSHOT.jar /app/Hackathon-0.0.1-SNAPSHOT.jar
COPY import.sql /docker-entrypoint-initdb.d/

CMD ["java", "-jar", "/app/Hackathon-0.0.1-SNAPSHOT.jar"]
