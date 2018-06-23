FROM dxmann73/alpine-openjdk

# based on alpine-wildfly from Jørgen Mittet <njmittet@gmail.com>
MAINTAINER David Mann <dxmann73@gmail.com>

ENV WILDFLY_VERSION 12.0.0.Final
ENV JBOSS_HOME /opt/jboss/wildfly
ENV DEPLOYMENT_DIR ${JBOSS_HOME}/standalone/deployments/

USER root
RUN mkdir -p /opt/jboss && adduser -D -h /opt/jboss jboss

USER jboss
WORKDIR /opt/jboss
RUN curl -O http://download.jboss.org/wildfly/$WILDFLY_VERSION/wildfly-$WILDFLY_VERSION.zip \
    && unzip wildfly-$WILDFLY_VERSION.zip \
    && mv $HOME/wildfly-$WILDFLY_VERSION $HOME/wildfly \
    && rm wildfly-$WILDFLY_VERSION.zip

# TODO place kafka files into applibs or so

ENTRYPOINT ${JBOSS_HOME}/bin/standalone.sh -b=0.0.0.0
EXPOSE 8080 9990
