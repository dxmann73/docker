#!/bin/bash

cp ../wildfly-swarm-demo/target/wildfly-swarm-demo-hollow-swarm.jar .

docker build -t dxmann73/wildfly-swarm .