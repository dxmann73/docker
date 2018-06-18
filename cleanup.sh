#!/usr/bin/bash

docker-compose down

sleep 10

docker volume rm docker_kafka-data
docker volume rm docker_kafka-logs
docker volume rm docker_zookeeper-data
docker volume rm docker_zookeeper-logs
