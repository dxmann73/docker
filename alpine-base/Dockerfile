FROM alpine:3.8

MAINTAINER David Mann <dxmann73@gmail.com>

ENV SERVICE_USER=svcusr \
    SERVICE_UID=1000 \
    SERVICE_GROUP=svcgrp \
    SERVICE_GID=1000

# TODO maybe fix timezones here in the base image
# manually add TZ variable as zookeeper does seem to pick up neither /etc/localtime nor /etc/timezone
# TODO if activated here, remove it from kafka and zookeeper containers, respectively
# ENV TZ=Europe/Berlin

RUN apk update \
 && apk add bash curl wget \
 && apk add tzdata \
 && cp /usr/share/zoneinfo/Europe/Berlin /etc/localtime \
 && cp /usr/share/zoneinfo/Europe/Berlin /etc/timezone \
 && apk del tzdata \
 && rm -rf /var/cache/apk/* \
 && mkdir /opt

RUN addgroup -g ${SERVICE_GID} ${SERVICE_GROUP} \
 && adduser -D -H -G ${SERVICE_GROUP} -s /sbin/nologin -u ${SERVICE_UID} ${SERVICE_USER}
