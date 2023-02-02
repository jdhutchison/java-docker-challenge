#!/bin/sh
####################################################
# set-metadata: This script will set the application
# metadata values in application.yaml, version and sha.
# The version is pulled out of the build.gradle file
# and the sha value obtained from a LAST_COMMIT_SHA environment
# variable (which should be set by the CI pipeline.
####################################################

# Obtain the version and replace in application.yaml- first find the line with the
# version set, then grab everything after '=' and then strip any whitespace with sed.
version=$(grep ^version build.gradle | cut -d'=' -f2 | sed -e 's/^[[:space:]]*//')
sed -i "s/version: .*$/version: ${version}/" src/main/resources/application.yaml

# Set the SHA value with the environment variable
sed -i "s/sha: .*$/sha: ${LAST_COMMIT_SHA}/" src/main/resources/application.yaml
