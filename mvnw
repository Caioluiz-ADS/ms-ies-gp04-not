#!/bin/sh
#
# Maven wrapper script for Unix/Linux/macOS
#
set -e

BASE_DIR=$(dirname "$(readlink -f "$0")" 2>/dev/null || dirname "$(realpath "$0")" 2>/dev/null || cd "$(dirname "$0")" && pwd)

MAVEN_WRAPPER_PROPERTIES="$BASE_DIR/.mvn/wrapper/maven-wrapper.properties"

if [ -f "$MAVEN_WRAPPER_PROPERTIES" ]; then
  DISTRIBUTION_URL=$(grep "distributionUrl" "$MAVEN_WRAPPER_PROPERTIES" | sed 's/.*=//')
  MAVEN_VERSION=$(echo "$DISTRIBUTION_URL" | sed 's/.*apache-maven-//' | sed 's/-bin.zip//')
fi

MAVEN_HOME="$HOME/.m2/wrapper/dists/apache-maven-${MAVEN_VERSION}"

if [ ! -d "$MAVEN_HOME" ]; then
  mkdir -p "$MAVEN_HOME"
  echo "Downloading Maven $MAVEN_VERSION..."
  curl -sL "$DISTRIBUTION_URL" -o "/tmp/maven.zip"
  unzip -q "/tmp/maven.zip" -d "$MAVEN_HOME"
  rm "/tmp/maven.zip"
fi

MVN_CMD=$(find "$MAVEN_HOME" -name "mvn" -type f | head -1)

exec "$MVN_CMD" "$@"
