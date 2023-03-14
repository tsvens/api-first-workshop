FROM sagcr.azurecr.io/webmethods-microservicesruntime:10.15.0.2
MAINTAINER SoftwareAG

USER root

COPY ${PACKAGE} /opt/softwareag/IntegrationServer/packages/${PACKAGE}

COPY config /opt/softwareag/IntegrationServer/config
COPY Listeners/listeners.cnf /opt/softwareag/IntegrationServer/packages/WmRoot/config
COPY acls/*.cnf /opt/softwareag/IntegrationServer/config/

RUN chown 1724:1724 -R /opt/softwareag/IntegrationServer/packages/*

USER 1724
