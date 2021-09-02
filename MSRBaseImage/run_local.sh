#!/bin/bash
tar -cf - . | gzip -9 | docker run \
  --interactive -v $(pwd):/workspace -v /Users/misja/.docker:/kaniko/.docker gcr.io/kaniko-project/executor:latest \
  --context tar://stdin \
  --no-push \
  --insecure --skip-tls-verify \
  --build-arg BUILDER_IMAGE=registry.master.servers/commandcentral-builder:10.7.104 \
  --build-arg BASE_IMAGE=registry.master.servers/java:10.7.104
