FROM softwareag/webmethods-microservicesruntime:10.11.0.2

MAINTAINER SoftwareAG

USER root

COPY ${PACKAGE} /opt/softwareag/IntegrationServer/packages/${PACKAGE}

RUN chown 1724:1724 -R /opt/softwareag/IntegrationServer/packages/*
RUN chown 1724:1724 /opt/softwareag/IntegrationServer/config/licenseKey.xml

USER 1724
