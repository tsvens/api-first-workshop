ARG BASE_IMAGE

FROM $BASE_IMAGE

COPY --chown=1724:1724 ${PACKAGE} /opt/softwareag/IntegrationServer/packages/${PACKAGE}
COPY --chown=1724:1724 ConnectedDemos /opt/softwareag/IntegrationServer/packages/ConnectedDemos
COPY --chown=1724:1724 ConnectedDemosTCDB /opt/softwareag/IntegrationServer/packages/ConnectedDemosTCDB
COPY --chown=1724:1724 config /opt/softwareag/IntegrationServer/config
