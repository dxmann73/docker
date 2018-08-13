FROM dxmann73/alpine-openjdk

MAINTAINER David Mann <dxmann73@gmail.com>

ENV SERVICE_NAME=wildfly-swarm-demo
ENV HOLLOW_JAR_NAME=${SERVICE_NAME}-hollow-swarm.jar

WORKDIR /opt/swarm

# http and admin console ports
EXPOSE 8080 9990

ADD ${HOLLOW_JAR_NAME} ${HOLLOW_JAR_NAME}

ENTRYPOINT ["sh", "-c", "java -Djava.net.preferIPv4Stack=true -Djava.net.preferIPv4Addresses=true -Djava.security.egd=file:/dev/./urandom -jar ${HOLLOW_JAR_NAME} *.war"]
