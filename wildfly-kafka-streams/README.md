wildfly-kafka-streams
==============

Wildfly standalone image with deployment target set up
TODO make this target reference the build artifact directly

Kafka Streams libraries live directly in the application server to allow for really thin wars 



Build
--------
```
docker build -t wildfly-kafka-streams .
```

Usage
--------


Configuration
-------------
[Start Wildfly](https://docs.jboss.org/author/display/WFLY10/Getting+Started+Guide#GettingStartedGuid0e-StartingWildFly10) with different configurations.

The default Web profile requires no configuration.

Start Wildfly with the Full profile: 
~~~~
docker run -it --rm -e STANDALONE=standalone-full application  
~~~~
