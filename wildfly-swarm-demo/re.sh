#!/bin/bash
docker build -t dxmann73/wildfly-swarm-demo .

docker rm -f wildfly-swarm-demo || true \
    && docker run -it -p 8080:8080 -p 4848:4848 -p 8787:8787 --name wildfly-swarm-demo dxmann73/wildfly-swarm-demo
