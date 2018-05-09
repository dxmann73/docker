#!/usr/bin/bash

docker-compose up -d

# TODO wait for kafka to be started, e.g. by letting compose start in another process
sleep 10

docker-compose exec kafka \
kafka-topics.sh --create --topic foo --partitions 1 --replication-factor 1 --if-not-exists --zookeeper localhost:2181

docker-compose exec kafka \
bash -c "seq 42 | kafka-console-producer.sh --request-required-acks 1 --broker-list localhost:9092 --topic foo && echo 'Produced 42 messages.'"

docker-compose exec kafka kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic foo --from-beginning --max-messages 42

