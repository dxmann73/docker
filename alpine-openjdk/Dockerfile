FROM dxmann73/alpine-base

# based on alpine-openjdk from Jørgen Mittet <njmittet@gmail.com>
MAINTAINER David Mann <dxmann73@gmail.com>

ENV JAVA_DISTRIBUTION openjdk
ENV JAVA_VERSION 8

RUN apk update \
 && apk add "$JAVA_DISTRIBUTION$JAVA_VERSION" --update \
 && rm -rf /var/cache/apk/* \
 && ln -s "/usr/lib/jvm/java-1.$JAVA_VERSION-openjdk/bin/javac" /usr/bin/javac
