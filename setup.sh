#!/bin/bash

sudo docker rm --force redis-service publisher subscriber-1 subscriber-2 &&
sudo docker rmi prs-coursework_publisher prs-coursework_subscriber-1 prs-coursework_subscriber-2 &&
sudo mvn clean package -DskipTests -f ./publisher/pom.xml &&
sudo mvn clean package -DskipTests -f ./subscriber/pom.xml &&
sudo docker-compose build &&
sudo docker-compose up -d