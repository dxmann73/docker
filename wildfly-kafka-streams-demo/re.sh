#!/bin/sh
mvn --batch-mode clean install

# copy into running wildfly deployment directory
cp target/wildfly-kafka-streams-demo.war /c/Users/dave/dockervolumes/wildfly-kafka/deployments
