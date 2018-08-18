#!/bin/sh
sh build.sh

docker rm -f wildfly-standalone-demo || true \
    && docker run -it --rm -p 8080:8080 -p 4848:4848 -p 8787:8787 --name wildfly-standalone-demo dxmann73/wildfly-standalone-demo