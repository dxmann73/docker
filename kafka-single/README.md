kafka-single
=========================

Contains a single node kafka server, as per the [quickstart tutorial](https://kafka.apache.org/quickstart).

Basic dockerfile taken from the [rawmind kafka docker file](https://github.com/rawmind0/alpine-kafka/blob/master/Dockerfile)
- separate kafka user and group
- nice way to set versions

Kafka config changes to avoid [missing logs on reboot](https://stackoverflow.com/questions/32437415/kafka-loses-all-topics-on-reboot)
- broker logs live in /var/opt/kafka
- log4j logs live in /var/log/kafka
- other changes to come soon TM

Directory layout according to the [Filesystem Hierarchy Standard](https://serverfault.com/questions/24523/meaning-of-directories-on-unix-and-unix-like-systems)


Build and usage
--------
```
docker build -t kafka-single .
```

~~~~
docker run -d --rm -p 9092:9092 --name kafka kafka-single
~~~~

