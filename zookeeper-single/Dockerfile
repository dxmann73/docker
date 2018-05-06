FROM dxmann73/alpine-openjdk
# based on rawmind0/alpine-kafka
MAINTAINER David Mann <dxmann73@gmail.com>

ENV SERVICE_HOME=/opt/kafka \
    SERVICE_NAME=kafka \
    SCALA_VERSION=2.12 \
    SERVICE_VERSION=1.0.0 \
    SERVICE_USER=zookeeper \
    SERVICE_UID=10003 \
    SERVICE_GROUP=zookeeper \
    SERVICE_GID=10003 \
    SERVICE_VOLUME=/opt/tools \
    SERVICE_URL=http://ftp.fau.de/apache/kafka
ENV SERVICE_RELEASE=kafka_"$SCALA_VERSION"-"$SERVICE_VERSION" \
    SERVICE_CONF=${SERVICE_HOME}/config/zookeeper.properties \
    SERVICE_DATA_DIR=/var/opt/zookeeper \
    SERVICE_LOG_DIR=/var/log/zookeeper \
    PATH=$PATH:${SERVICE_HOME}/bin

# Install and configure kafka
RUN curl -sS -k ${SERVICE_URL}/${SERVICE_VERSION}/${SERVICE_RELEASE}.tgz | gunzip -c - | tar -xf - -C /opt \
  && mv /opt/${SERVICE_RELEASE} ${SERVICE_HOME} \
  && rm -rf ${SERVICE_HOME}/bin/windows \
  && cp ${SERVICE_CONF} ${SERVICE_CONF}.orig \
  && mkdir -p ${SERVICE_DATA_DIR} \
  && mkdir -p ${SERVICE_LOG_DIR} \
  && addgroup -g ${SERVICE_GID} ${SERVICE_GROUP} \
  && adduser -g "${SERVICE_NAME} user" -D -h ${SERVICE_HOME} -G ${SERVICE_GROUP} -s /sbin/nologin -u ${SERVICE_UID} ${SERVICE_USER} \
  && chmod +x ${SERVICE_HOME}/bin/*.sh \
  && chown -R ${SERVICE_USER}:${SERVICE_GROUP} ${SERVICE_DATA_DIR} \
  && chown -R ${SERVICE_USER}:${SERVICE_GROUP} ${SERVICE_LOG_DIR}

USER $SERVICE_USER
WORKDIR $SERVICE_HOME
# replace config with adapted config
COPY ./zookeeper.properties ${SERVICE_CONF}
ENV LOG_DIR=${SERVICE_LOG_DIR}

CMD ${SERVICE_HOME}/bin/zookeeper-server-start.sh config/zookeeper.properties
EXPOSE 2181
