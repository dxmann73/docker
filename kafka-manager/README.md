kafka-manager
=========================
Contains a single server with [kafka-manager](https://github.com/yahoo/kafka-manager/releases) v1.3.3.18 installed on it.


Preparing Kafka manager
-------------------------
You need to download kafka-manager (see above) and build it with [sbt](https://stackoverflow.com/questions/46650747/can-i-use-yahoo-kafka-manager-if-i-dont-have-sbt-locally)
```
sbt clean dist
```

This will create a zip in ```kafka-manager-1.3.3.18\target\universal\kafka-manager-1.3.3.18.zip```

Copy this file to the current directory ```.``` and adapt the version in the Dockerfile

##### Note that kafka manager will bind to port 9000 by default.


Build
--------
```
docker build -t dxmann73/kafka-manager .
```
Usage
------- 
Start the kafka / zookeeper cluster, then run
```
docker run -d --rm -p 9000:9000 --name kafka-manager dxmann73/kafka-manager .
```
and connect to http://localhost:9000
