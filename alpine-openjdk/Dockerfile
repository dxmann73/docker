FROM alpine:3.7

# based on alpine-openjdk from Jørgen Mittet <njmittet@gmail.com>
MAINTAINER David Mann <dxmann73@gmail.com>

ENV JAVA_DISTRIBUTION openjdk
ENV JAVA_VERSION 8

# TODO add curl, seems to be a networking problem
# curl (missing):
#    required by: world[curl]
# RUN apk add curl
# Try instead: apk update && apk add curl && rm -rf /var/cache/apk/*

RUN apk add "$JAVA_DISTRIBUTION$JAVA_VERSION" --update && rm -rf /var/cache/apk/* && ln -s "/usr/lib/jvm/java-1.$JAVA_VERSION-openjdk/bin/javac" /usr/bin/javac
