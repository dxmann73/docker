# docker
Dockerfiles plus dependencies


# docker compose

```
docker-compose up -d

docker-compose ps

docker-compose logs zookeeper | grep binding
docker-compose logs kafka | grep start
```

# kafka topic creation

```
echo creating topic foo
docker-compose exec kafka \
kafka-topics.sh --create --topic foo --partitions 1 --replication-factor 1 --if-not-exists --zookeeper localhost:2181

echo check topic foo status
docker-compose exec kafka \
kafka-topics.sh --describe --topic foo --zookeeper localhost:2181

echo creating 42 messages
docker-compose exec kafka \
bash -c "seq 42 | kafka-console-producer.sh --request-required-acks 1 --broker-list localhost:9092 --topic foo && echo 'Produced 42 messages.'"

echo reading 42 messages
docker-compose exec kafka \
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic foo --from-beginning --max-messages 42

echo stopping all services
docker-compose down
```
