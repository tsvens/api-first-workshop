#!/bin/bash

if [ -f licenses.zip ]; then
  mkdir licenses
  cd licenses
  unzip ../licenses.zip
  IS_LICENSE=$(find . -name \*MicroservicesRuntime\*.xml)
  WMT_LICENSE=$(find . -name \*WmTestSuite\*.xml)
  mv "$IS_LICENSE" ISLicense.xml
  mv "$WMT_LICENSE" WmTestSuite100.xml
  cd ..
  kubectl apply -f licenseUploadPod.yml
  POD=$(kubectl -n cicd get pods -l pod=swag-licenses --output=jsonpath={.items..metadata.name})
  kubectl -n cicd wait --for=condition=Ready pod/$POD
  kubectl -n api-first-workshop create configmap msr-license --from-file=./licenses/ISLicense.xml
  kubectl -n cicd cp ./licenses/ISLicense.xml $POD:/licenses/ISLicense.xml
  kubectl -n cicd cp ./licenses/WmTestSuite100.xml $POD:/licenses/WmTestSuite100.xml
  kubectl -n cicd cp SoftwareAGInstaller*.bin $POD:/licenses/SoftwareAGInstaller.bin
  kubectl -n cicd delete pod $POD
  rm -rf licenses
else
  echo "No license zip file found. Please place you zip file containing your licenses in this directory as licenses.zip"
fi
