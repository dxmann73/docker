# Docker
Dockerfiles plus dependencies

# Windows 7 setup hints
Docker Toolbox needs VirtualVM under Windows 7

Set up VirtualBox port forwarding in Settings > Network > Erweitert 

  => see https://www.youtube.com/watch?v=_CZar_4_vbk#

## boot2docker machine TZ settings special for Windows 7 / Docker Toolkit
You need to add some permanent settings to the docker machine
as  per the [boot2docker FAQ](https://github.com/boot2docker/boot2docker/blob/17.03.x/doc/FAQ.md#local-customisation-with-persistent-partition)
- create ```/var/lib/boot2docker/bootlocal.sh``` in the docker machine
- give exec flag ```chmod u+x bootlocal.sh```

As described in the [Tiny Core Linux forum](http://forum.tinycorelinux.net/index.php?topic=5017.msg27012#msg27012) and [Wiki](http://wiki.tinycorelinux.net/wiki:time_zone)
```
cd /var/lib/boot2docker
tce-fetch.sh tzdata.tcz
mkdir ext
sudo mount tzdata.tcz ext -t squashfs -o loop,ro,bs=4096
# I needed Europe/Berlin; find your timezone by scanning the ./ext directory
cp ext/usr/local/share/zoneinfo/Europe/Berlin ./Europe-Berlin.tz
umount ext
rm -rf ext tzdata.tcz
```
Europe-Berlin.tz should survive restarts of the docker machine now.

Finally, copy the timezone file when starting up docker-machine by adding the following to the bootlocal script
```
#!/bin/sh
cp /var/lib/boot2docker/Europe-Berlin.tz /etc/localtime
```

You should see the correct time now when you enter ```date```

 
# TODOs
- Sort images and push them to the dxmann73 docker registry
- alias ll in alpine bash and change prompt to show cwd
- LABEL maintainer since MAINTAINER is deprecated


# docker compose

```
docker-compose up -d

docker-compose ps

docker-compose logs zookeeper | grep binding
docker-compose logs kafka | grep start
```

# quickstart 

as per the [confluent docs](https://docs.confluent.io/current/installation/docker/docs/quickstart.html)

```
echo creating topic foo
docker-compose exec kafka \
kafka-topics.sh --create --topic foo --partitions 1 --replication-factor 1 --if-not-exists --zookeeper localhost:2181

echo check topic foo status
docker-compose exec kafka \
kafka-topics.sh --describe --topic foo --zookeeper localhost:2181

echo check general topic status
docker-compose exec kafka \
kafka-topics.sh --describe --zookeeper localhost:2181

echo creating 42 messages
docker-compose exec kafka \
bash -c "seq 42 | kafka-console-producer.sh --request-required-acks 1 --broker-list localhost:9092 --topic foo && echo 'Produced 42 messages.'"

echo reading 42 messages
docker-compose exec kafka \
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic foo --from-beginning --max-messages 42

echo stopping all services
docker-compose down
```

```
docker volume ls
docker volume inspect zookeeper-logs
```

