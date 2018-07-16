FROM dxmann73/alpine-openjdk

# based on rawmind0/alpine-kafka
MAINTAINER David Mann <dxmann73@gmail.com>

# default value for zookeeper.connect
ENV DOCKER_MACHINE_IP=192.168.99.100
ENV ZK_HOSTS=${DOCKER_MACHINE_IP}:2181 \
    ADVERTISED_HOST=${DOCKER_MACHINE_IP} \
    ADVERTISED_PORT=9092

ENV SERVICE_HOME=/opt/kafka \
    SERVICE_NAME=kafka \
    SCALA_VERSION=2.12 \
    SERVICE_VERSION=1.0.0 \
    SERVICE_VOLUME=/opt/tools \
    SERVICE_URL=http://ftp.fau.de/apache/kafka
ENV SERVICE_RELEASE=kafka_"$SCALA_VERSION"-"$SERVICE_VERSION" \
    SERVICE_CONF=${SERVICE_HOME}/config/server.properties \
    SERVICE_DATA_DIR=/var/opt/kafka \
    SERVICE_LOG_DIR=/var/log/kafka \
    PATH=$PATH:${SERVICE_HOME}/bin
# log4j setting
ENV LOG_DIR=${SERVICE_LOG_DIR}

# Download, install and configure kafka
RUN curl -sS -k ${SERVICE_URL}/${SERVICE_VERSION}/${SERVICE_RELEASE}.tgz | gunzip -c - | tar -xf - -C /opt \
  && mv /opt/${SERVICE_RELEASE} ${SERVICE_HOME} \
  && rm -rf ${SERVICE_HOME}/bin/windows \
  && mkdir -p ${SERVICE_DATA_DIR} \
  && mkdir -p ${SERVICE_LOG_DIR} \
  && chmod +x ${SERVICE_HOME}/bin/*.sh \
  && chown -R ${SERVICE_USER}:${SERVICE_GROUP} ${SERVICE_HOME} \
  && chown -R ${SERVICE_USER}:${SERVICE_GROUP} ${SERVICE_DATA_DIR} \
  && chown -R ${SERVICE_USER}:${SERVICE_GROUP} ${SERVICE_LOG_DIR}

# replace config
COPY ./server.properties ${SERVICE_CONF}
RUN  chown -R ${SERVICE_USER}:${SERVICE_GROUP} ${SERVICE_CONF} \
  && chmod -x ${SERVICE_CONF}

USER $SERVICE_USER
WORKDIR $SERVICE_HOME

EXPOSE 9092
# we use CMD here because we want to be able to modify the startup sequence
CMD ${SERVICE_HOME}/bin/kafka-server-start.sh config/server.properties \
    --override zookeeper.connect=${ZK_HOSTS} \
    --override advertised.host.name=${ADVERTISED_HOST} \
    --override advertised.port=${ADVERTISED_PORT}

