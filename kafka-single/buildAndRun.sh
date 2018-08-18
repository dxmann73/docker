#!/bin/sh
sh build.sh

docker run -it --rm -p 9092:9092 --name kafka-single dxmann73/kafka-single