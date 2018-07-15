zookeeper-single
=========================

Contains a single node zookeeper server, as per the [quickstart tutorial](https://kafka.apache.org/quickstart).

Basic dockerfile taken from the [rawmind kafka docker file](https://github.com/rawmind0/alpine-kafka/blob/master/Dockerfile)
- separate zookeeper user and group
- nice way to set versions

Zookeeper config changes to avoid [missing logs on reboot](https://stackoverflow.com/questions/32437415/kafka-loses-all-topics-on-reboot)
- dataDir is /var/opt/zookeeper
- log4j logs live in /var/log/zookeeper

Directory layout according to the [Filesystem Hierarchy Standard](https://serverfault.com/questions/24523/meaning-of-directories-on-unix-and-unix-like-systems)


Build and run the zookeeper server:
--------------------------------------
```
docker build -t dxmann73/zookeeper-single .
```

~~~~
# you need to bind the port:
docker run -d --rm -p 2181:2181 --name zookeeper dxmann73/zookeeper-single

# to attach
docker exec -it zookeeper bash

docker stop zookeeper
~~~~



