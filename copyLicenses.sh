#!/bin/bash

if [ -f licenses.zip ]; then
  mkdir licenses
  cd licenses
  unzip ../licenses.zip
  IS_LICENSE=$(find . -name \*Integration\?Server\*.xml)
  kubectl apply -f licenseUploadPod.yml
  POD=$(kubectl -n cicd get pods -l pod=swag-licenses --output=jsonpath={.items..metadata.name})
  kubectl -n cicd wait --for=condition=Ready pod/$POD 
  kubectl -n cicd cp $IS_LICENSE $POD:/licenses/ISLicense.xml
  kubectl -n cicd cp SoftwareAGInstaller*.bin $POD:/licenses/SoftwareAGInstaller.bin
  kubectl -n cicd delete pod $POD
  cd ..
  rm -rf licenses
else
  echo "No license zip file found. Please place you zip file containing your licenses in this directory as licenses.zip"
fi
