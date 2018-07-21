# wildfly-standalone

Originally based on alpine-wildfly from Jørgen Mittet https://github.com/njmittet/alpine-wildfly.
[Docker](https://www.docker.com/) image for running Java EE applications in [Wildfly](http://www.wildfly.org/).
Based on [Alpine Linux](http://alpinelinux.org/) and [OpenJDK](http://openjdk.java.net/).
Use this image as a base for you application image. [Image on Docker Hub](https://hub.docker.com/r/dxmann73/alpine-wildfly/).

## Build
```
docker build -t dxmann73/wildfly-standalone .
```
## Usage
### Interactive mode
- Default port binding is 8080
```
docker run -it --rm -p 8080:8080 --name wildfly dxmann73/wildfly-standalone
```
After the startup sequence has completed (approx. 13s) you can reach the wildfly default page under http://localhost:8080/
### Detached mode
- Default port binding is 8080
- Log files are in /opt/jboss/wildfly/standalone/log
  - You can mount them into your local file system using ```--volume /your/local/log/dir:/opt/jboss/wildfly/standalone/log```
  - Note that you need to add ```/your/local/log/dir``` or any of its subdirs as shared folders in VirtualBox first! 
  - By default, only C:\Users is mounted on windows machines (as /c/Users, note the lowercase c)
```
docker run -d  --rm --volume /c/Users/dave/dockervolumes/wildfly-standalone/logs:/opt/jboss/wildfly/standalone/log \
           -p 8080:8080 --name wildfly dxmann73/wildfly-standalone
```
### Connect to the container in detached mode
```
docker exec -it wildfly bash
```

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
