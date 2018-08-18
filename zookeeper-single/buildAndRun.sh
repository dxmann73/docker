#!/bin/sh
sh build.sh

docker run -d --rm -p 2181:2181 --name zookeeper-single dxmann73/zookeeper-single