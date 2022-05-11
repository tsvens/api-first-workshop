FROM softwareag/webmethods-microservicesruntime:10.11.0.0

MAINTAINER SoftwareAG

USER root

ADD ISLicense.xml /wm-installer/ISLicense.xml

COPY ${PACKAGE} /opt/softwareag/IntegrationServer/packages/${PACKAGE}
COPY ISLicense.xml /opt/softwareag/IntegrationServer/config/licenseKey.xml

RUN chown 1724:1724 -R /opt/softwareag/IntegrationServer/packages/*
RUN chown 1724:1724 /opt/softwareag/IntegrationServer/config/licenseKey.xml

USER 1724
