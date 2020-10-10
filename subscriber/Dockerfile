FROM openjdk:11-jdk
WORKDIR /home
COPY ./target/publisher-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/home/app.jar"]

