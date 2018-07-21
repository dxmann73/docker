kafka-manager
=========================
Contains a single server with [kafka-manager](https://github.com/yahoo/kafka-manager/releases) v1.3.3.18 installed on it.
Need to build it with [sbt](https://stackoverflow.com/questions/46650747/can-i-use-yahoo-kafka-manager-if-i-dont-have-sbt-locally)
```
sbt clean dist
```
This will create a zip in ```kafka-manager-1.3.3.18\target\universal\kafka-manager-1.3.3.18.zip```
Unzip it and copy it to ```kafka-manager-1.3.3.18-bin``` in the directory of the dockerfile (should be .)
Then you should see ```./kafka-manager-1.3.3.18-bin/bin/kafka-manager```
You can then build the docker image. Note that, by default, kafka manager will bind to port 9000 internally.


Build
--------
```
docker build -t dxmann73/kafka-manager .
```
Usage
------- 
Start the kafka / zookeeper cluster, then run
```
docker run -d --rm -p 9000:9000 --name kafka-manager kafka-manager .
```
and connect to http://localhost:9000
