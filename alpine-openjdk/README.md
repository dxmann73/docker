alpine-openjdk
==============

based on alpine-openjdk from Jørgen Mittet https://github.com/njmittet/alpine-openjdk
[Docker](https://www.docker.com/) image for running [Java](https://www.java.com/) applications. 
Based on [Alpine Linux](http://alpinelinux.org/) and [OpenJDK](http://openjdk.java.net/).

[Image on Docker Hub](https://hub.docker.com/r/dxmann73/alpine-openjdk/).

Versions
--------
Alpine Linux: 3.8
Java: The latest major version provided by the Alpine Linux version.

Build
--------
```
docker build -t dxmann73/alpine-openjdk .
```

Run
--------
```
docker run -it --rm --name jdk8 dxmann73/alpine-openjdk /bin/sh -c "javac -version"
```
expected output is javac 1.8.0_171