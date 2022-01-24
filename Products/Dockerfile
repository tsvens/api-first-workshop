ARG BASE_IMAGE
ARG PACKAGE

FROM $BASE_IMAGE

COPY --chown=1724:1724 $PACKAGE /opt/softwareag/IntegrationServer/instances/default/packages/$PACKAGE
COPY --chown=1724:1724 ConnectedDemos /opt/softwareag/IntegrationServer/instances/default/packages/ConnectedDemos
COPY --chown=1724:1724 ConnectedDemosTCDB /opt/softwareag/IntegrationServer/instances/default/packages/ConnectedDemosTCDB
COPY --chown=1724:1724 config /opt/softwareag/IntegrationServer/instances/default/config
