FROM dxmann73/alpine-openjdk
MAINTAINER David Mann <dxmann73@gmail.com>

ENV SERVICE_NAME=kafka-manager \
    SERVICE_VERSION=1.3.3.18
ENV SERVICE_ID=${SERVICE_NAME}-${SERVICE_VERSION}
ENV SERVICE_HOME=/opt/${SERVICE_NAME}
ENV PATH=${PATH}:${SERVICE_HOME}/bin

# Copy the kafka-manager binaries
COPY ./${SERVICE_ID}.zip /opt

WORKDIR /opt

RUN  unzip ${SERVICE_ID}.zip \
  && rm ${SERVICE_ID}.zip \
  && mv ${SERVICE_ID}/ ${SERVICE_HOME}/ \
  && chmod +x ${SERVICE_HOME}/bin/* \
  && chown -R ${SERVICE_USER}:${SERVICE_GROUP} ${SERVICE_HOME}

USER ${SERVICE_USER}

EXPOSE 9000
CMD ${SERVICE_HOME}/bin/${SERVICE_NAME}
