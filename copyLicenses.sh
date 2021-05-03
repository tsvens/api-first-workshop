#!/bin/bash

if [ -f licenses.zip ]; then
  kubectl apply -f licenseUploadPod.yml
  POD=$(kubectl -n cicd get pods -l pod=swag-licenses --output=jsonpath={.items..metadata.name})
  kubectl -n cicd wait --for=condition=Ready pod/$POD
  kubectl -n cicd cp licenses.zip $POD:/licenses
  kubectl -n cicd delete pod $POD
else
  echo "No license zip file found. Please place you zip file containing your licenses in this directory as licenses.zip"
fi
