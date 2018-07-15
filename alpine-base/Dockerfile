FROM alpine:3.8

MAINTAINER David Mann <dxmann73@gmail.com>

ENV SERVICE_USER=svcusr \
    SERVICE_UID=1000 \
    SERVICE_GROUP=svcgrp \
    SERVICE_GID=1000

RUN apk update \
 && apk add bash curl wget \
 && rm -rf /var/cache/apk/* \
 && mkdir /opt

RUN addgroup -g ${SERVICE_GID} ${SERVICE_GROUP} \
 && adduser -D -H -G ${SERVICE_GROUP} -s /sbin/nologin -u ${SERVICE_UID} ${SERVICE_USER}
