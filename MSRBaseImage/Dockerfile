###############################################################################
#  Copyright � 2013 - 2018 Software AG, Darmstadt, Germany and/or its licensors
#
#   SPDX-License-Identifier: Apache-2.0
#
#     Licensed under the Apache License, Version 2.0 (the "License");
#     you may not use this file except in compliance with the License.
#     You may obtain a copy of the License at
#
#        http://www.apache.org/licenses/LICENSE-2.0
#
#     Unless required by applicable law or agreed to in writing, software
#     distributed under the License is distributed on an "AS IS" BASIS,
#     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#     See the License for the specific language governing permissions and
#     limitations under the License.                                                            
#
###############################################################################

ARG BUILDER_IMAGE
ARG BASE_IMAGE

FROM $BUILDER_IMAGE as builder

RUN groupadd -g 1724 swag && useradd -u 1724 -g 1724 swagadmin

USER 1724
ADD --chown=1724:1724 SoftwareAGInstaller.bin ./
ADD --chown=1724:1724 createIsImage.script ./

RUN chmod +x SoftwareAGInstaller.bin
# provision and unit test
RUN ./SoftwareAGInstaller.bin -readScript createIsImage.script

FROM $BASE_IMAGE

RUN groupadd -g 1724 swag && useradd -u 1724 -g 1724 swagadmin
USER 1724

EXPOSE 5555 9999 8094 8092 8093

# copy everything from the builder stage $SAG_HOME
COPY --from=builder --chown=1724:1724 /tmp/installation_dir_is-tca-image $SAG_HOME/

# custom entry point
ADD entrypoint.sh /opt/softwareag/
ENTRYPOINT /opt/softwareag/entrypoint.sh

# Current working directory for all commands. This is where the MSC installation is copied to within the image.
WORKDIR /opt/softwareag
