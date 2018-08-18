#!/bin/sh
sh build.sh

docker run -it --rm -p 8080:8080 -p 4848:4848 --name wildfly-kafka-streams dxmann73/wildfly-kafka-streams
