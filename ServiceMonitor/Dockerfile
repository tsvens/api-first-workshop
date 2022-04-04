FROM softwareag/webmethods-microservicesruntime:10.11.0.0

MAINTAINER SoftwareAG

USER root

COPY ${PACKAGE} /opt/softwareag/IntegrationServer/packages/${PACKAGE}

COPY config /opt/softwareag/IntegrationServer/config

RUN chown 1724:1724 -R /opt/softwareag/IntegrationServer/packages/*

USER 1724
