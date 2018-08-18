#!/bin/sh
sh build.sh

docker run -d --rm --volume /c/Users/dave/dockervolumes/wildfly-standalone/logs:/opt/jboss/wildfly/standalone/log \
           -p 8080:8080 --name wildfly-standalone dxmann73/wildfly-standalone