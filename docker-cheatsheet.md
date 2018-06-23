# build
```
docker build -t kafka-single .
docker build -t zookeeper-single .

docker container ls
```

# images
```
docker images -q -f dangling=true | xargs --no-run-if-empty docker rmi
docker rmi -f centos
```

# run/stop
```
docker run -d dxmann73/zookeeper-single
docker run -d -it --rm -p 9092:9092 kafka-single
docker run -d     --rm -p 2181:2181 --name zookeeper zookeeper-single
docker run -d     --rm -p 9092:9092 --name kafka kafka-single
docker run    -it      -p 9092:9092 kafka-single

docker stop kafka-single
```

# attach/info/inspect/logs

```
docker info

docker inspect 7296123ed721
docker inspect 7296123ed721 | grep IP

docker attach kafka-single

docker logs kafka-single
docker logs zookeeper-single
```

# ps and remove 
```
docker ps
docker ps -a
docker ps -q -f status=created | xargs --no-run-if-empty docker rm
docker ps -q -f status=exited | xargs --no-run-if-empty docker rm
```


# docker-compose

docker-compose is aliased as dc in ~/.bashrc

```
dc up
dc up -d

dc ps

dc logs kafka
dc logs zookeeper

dc volumes

dc down
```
