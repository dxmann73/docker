wildfly-standalone
==================

### based on alpine-wildfly from Jørgen Mittet https://github.com/njmittet/alpine-wildfly
[Docker](https://www.docker.com/) image for running Java EE applications in [Wildfly](http://www.wildfly.org/). Based on [Alpine Linux](http://alpinelinux.org/) and [OpenJDK](http://openjdk.java.net/). Use this image as base image for you application image.

[Image on Docker Hub](https://hub.docker.com/r/dxmann73/alpine-wildfly/).


Build
--------
```
docker build -t dxmann73/alpine-wildfly .
```

Usage
--------

Create a Dockerfile in your project root:
~~~~
FROM dxmann73/wildfly
ADD ./target/application.war /opt/jboss/wildfly/standalone/deployments/application.war
~~~~

Build and run the application container:
~~~~
docker build -t application .
docker run -it --rm application
~~~~

Configuration
-------------
[Start Wildfly](https://docs.jboss.org/author/display/WFLY10/Getting+Started+Guide#GettingStartedGuid0e-StartingWildFly10) with different configurations.

The default Web profile requires no configuration.

Start Wildfly with the Full profile: 
~~~~
docker run -it --rm -e STANDALONE=standalone-full application  
~~~~

TODO Add a custom configuration file to your Dockerfile:
~~~~
ADD ./standalone-custom.xml /opt/jboss/wildfly/standalone/configuration/standalone.xml
~~~~

Wildfly also comes with a [High Availability](https://docs.jboss.org/author/display/WFLY10/High+Availability+Guide) configuration.
~~~~
docker run -it --rm -e STANDALONE=standalone-full-ha application  
~~~~
