#!/bin/bash

if [[ -z "$EMPOWER_CREDS_USR" ]]; then
  echo no credentials provided
  echo please provide your empower Username:
  read -r EMPOWER_CREDS_USR
  echo Please provide your empower Password:
  read -r EMPOWER_CREDS_PSW

  export EMPOWER_CREDS_USR
  export EMPOWER_CREDS_PSW
fi

chmod +x SoftwareAGInstaller.bin
sed -i .bck 's/%EMPOWER_USER%/'$EMPOWER_CREDS_USR'/g' createIsImage.script
sed -i .bck.bck 's/%EMPOWER_PASSWORD%/'$EMPOWER_CREDS_PSW'/g' createIsImage.script

docker build  \
  -t mjheuveling/msr-base:10.11 \
  --build-arg BUILDER_IMAGE=redhat/ubi8 \
  --build-arg BASE_IMAGE=redhat/ubi8 \
  .

mv createIsImage.script.bck createIsImage.script
rm createIsImage.script.bck.bck
