#!/bin/sh
mvn --batch-mode clean install

docker build -t dxmann73/wildfly-standalone-demo .