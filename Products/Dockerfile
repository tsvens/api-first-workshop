FROM store/softwareag/webmethods-microservicesruntime:10.5

MAINTAINER SoftwareAG

USER root

COPY terracotta* /opt/softwareag/common/lib/
COPY ${PACKAGE} /opt/softwareag/IntegrationServer/packages/${PACKAGE}
COPY ConnectedDemos /opt/softwareag/IntegrationServer/packages/ConnectedDemos
COPY ConnectedDemosTCDB /opt/softwareag/IntegrationServer/packages/ConnectedDemosTCDB
COPY WmTCDBAdapter /opt/softwareag/IntegrationServer/packages/WmTCDBAdapter

COPY config /opt/softwareag/IntegrationServer/config

RUN chown 1724:1724 -R /opt/softwareag/IntegrationServer/packages/*

USER 1724
