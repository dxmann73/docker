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

bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties
bin/kafka-topics.sh --create \
    --zookeeper localhost:2181 \
    --replication-factor 1 \
    --partitions 1 \
    --topic streams-plaintext-input

bin/kafka-topics.sh --create \
    --zookeeper localhost:2181 \
    --replication-factor 1 \
    --partitions 1 \
    --topic streams-wordcount-output \
    --config cleanup.policy=compact

bin/kafka-run-class.sh org.apache.kafka.streams.examples.wordcount.WordCountDemo

docker-compose exec kafka kafka-topics.sh --create --topic foo --partitions 1 --replication-factor 1 --if-not-exists --zookeeper localhost:2181
docker-compose exec kafka bash -c "seq 42 | kafka-console-producer.sh --request-required-acks 1 --broker-list localhost:9092 --topic foo && echo 'Produced 42 messages.'"
docker-compose exec kafka kafka-topics.sh --describe --topic foo --zookeeper localhost:2181
docker-compose exec kafka kafka-topics.sh --describe             --zookeeper localhost:2181

~~~~
