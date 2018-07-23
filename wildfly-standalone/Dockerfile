FROM dxmann73/alpine-openjdk

MAINTAINER David Mann <dxmann73@gmail.com>

ENV WILDFLY_VERSION=12.0.0.Final

ENV SERVICE_HOME=/opt/jboss/wildfly \
    SERVICE_NAME=wildfly-${WILDFLY_VERSION}
ENV JBOSS_HOME=${SERVICE_HOME} \
    SERVICE_LOG_DIR=${SERVICE_HOME}/standalone/log \
    DEPLOYMENT_DIR=${SERVICE_HOME}/standalone/deployments

WORKDIR /opt/jboss

# Download, install and configure wildfly
RUN curl -O http://download.jboss.org/wildfly/${WILDFLY_VERSION}/${SERVICE_NAME}.zip
RUN unzip ${SERVICE_NAME}.zip \
 && mv ${SERVICE_NAME} ${SERVICE_HOME} \
 && rm ${SERVICE_NAME}.zip \
 && mkdir -p ${SERVICE_LOG_DIR} \
 && mkdir -p ${DEPLOYMENT_DIR} \
 && chmod +x ${SERVICE_HOME}/bin/*.sh \
 && chown -R ${SERVICE_USER}:${SERVICE_GROUP} ${SERVICE_HOME} \
 && chown -R ${SERVICE_USER}:${SERVICE_GROUP} ${SERVICE_LOG_DIR} \
 && chown -R ${SERVICE_USER}:${SERVICE_GROUP} ${DEPLOYMENT_DIR}

# http and admin console ports
EXPOSE 8080 9990

# TODO find a way to pass --debug from outside
CMD ${JBOSS_HOME}/bin/standalone.sh --debug -b=0.0.0.0
