Wildfly with Kafka Streams
===========================
Wildfly standalone image with all external dependencies (Kafka Streams, slf4j, etc) living directly in the application server to allow for 
*really* skinny wars. 

All dependencies can be determined / rebuilt by removing ```<scope>provided</scope>``` from the pom.xml in the 
```wildfly-kafka-streams-demo``` project (but please leave ```javaee-api``` as provided ;-)).

The global module is added to the server manually by
- copying the module contents into the appropriate place in wildfly (it could also be symlink'ed)
- replacing the ```standalone.xml``` with a modified version, which contains a global module in the ```:ee``` subsystem section
This approach was taken from [here](http://javahowto.blogspot.com/2012/09/how-to-create-global-modules-in-jboss.html). As said there,
"Editing server configuration files is not a good idea", but for the moment this will do.
Later, we should use the CLI for this, as outlined [here](https://developer.jboss.org/thread/221534), basically by doing 
```
module add --name=com.oracle.jdbc --resources=ojdbc6.jar --dependencies=javax.api,javax.transaction.api
```
when setting up the server.

Build
--------
```
docker build -t dxmann73/wildfly-kafka-streams .
```
Usage
--------
Run the container without deployments:
```
docker run -it -p 8080:8080 -p 4848:4848 --name wildfly-kafka-streams dxmann73/wildfly-kafka-streams
```
If you want to add a deployment, see the ```wildfly-kafka-streams-demo``` Dockerfile
