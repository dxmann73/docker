wildfly-standalone
==================

### based on alpine-wildfly from Jørgen Mittet https://github.com/njmittet/alpine-wildfly
[Docker](https://www.docker.com/) image for running Java EE applications in [Wildfly](http://www.wildfly.org/). Based on [Alpine Linux](http://alpinelinux.org/) and [OpenJDK](http://openjdk.java.net/). Use this image as base image for you application image.
[Image on Docker Hub](https://hub.docker.com/r/dxmann73/alpine-wildfly/).

Build
--------
```
docker build -t dxmann73/wildfly-standalone .
# Local:
docker build -t wildfly-standalone .
```

Usage
--------
Log files are in /opt/jboss/wildfly/standalone/log. In order to mount directories on the local host, you need to add them as shared folders in VirtualBox. By default, only C:\Users is mounted (as /c/Users, note the lowercase c. Also keep in mind that the shell is different from the docker machine)
~~~~
docker run -it --rm application
docker run -d  --rm --volume /c/Dropbox/dev/projects/docker/wildfly-standalone/logs:/opt/jboss/wildfly/standalone/log application

# connect to the container 
docker exec -it <containerId> bash
~~~~

Configuration
-------------
[Start Wildfly](https://docs.jboss.org/author/display/WFLY10/Getting+Started+Guide#GettingStartedGuid0e-StartingWildFly10) with different configurations.

The default Web profile requires no configuration.

TODO Add a custom configuration file to your Dockerfile:
~~~~
ADD ./standalone-custom.xml /opt/jboss/wildfly/standalone/configuration/standalone.xml
~~~~

Wildfly also comes with a [High Availability](https://docs.jboss.org/author/display/WFLY10/High+Availability+Guide) configuration.
~~~~
docker run -it --rm -e STANDALONE=standalone-full-ha application  
~~~~
