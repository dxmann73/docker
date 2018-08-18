FROM dxmann73/alpine-openjdk

MAINTAINER David Mann <dxmann73@gmail.com>

ENV SERVICE_NAME=wildfly \
    SERVICE_VERSION=12.0.0.Final
ENV SERVICE_RELEASE=${SERVICE_NAME}-${SERVICE_VERSION}
ENV SERVICE_HOME=/opt/${SERVICE_RELEASE}
# targets for deployment and logging
ENV DEPLOYMENT_DIR=${SERVICE_HOME}/standalone/deployments/ \
    SERVICE_LOG_DIR=${SERVICE_HOME}/standalone/log/

# Download and install wildfly
WORKDIR /opt
RUN curl -O http://download.jboss.org/${SERVICE_NAME}/${SERVICE_VERSION}/${SERVICE_RELEASE}.zip \
  && unzip ${SERVICE_RELEASE}.zip \
  && rm ${SERVICE_RELEASE}.zip

# add global module
COPY ./wildfly-module-definition/* ${SERVICE_HOME}/modules/
# replace standalone.xml
COPY ./wildfly-config/standalone.xml ${SERVICE_HOME}/standalone/configuration/

# change owner and make scripts executable
RUN  chmod +x ${SERVICE_HOME}/bin/*.sh \
  && chown -R ${SERVICE_USER}:${SERVICE_GROUP} ${SERVICE_HOME}

# run as the service user
USER $SERVICE_USER
WORKDIR $SERVICE_HOME

EXPOSE 8080 9990
ENTRYPOINT ${SERVICE_HOME}/bin/standalone.sh -b=0.0.0.0
