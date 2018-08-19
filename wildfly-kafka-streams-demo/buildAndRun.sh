#!/bin/sh
sh build.sh

docker rm -f wildfly-kafka-streams-demo || true \
    && docker run -it \
    -p 8081:8080 -p 4849:4848 -p 8788:8787 \
    --network="docker_kafkanet" \
    --name wildfly-kafka-streams-demo dxmann73/wildfly-kafka-streams-demo