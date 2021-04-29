#!/usr/bin/env bash

set -o pipefail

BUILD_NR=${1}

REPO_DIR="$(cd "$(dirname "$0")/../" && pwd)"

# Create Version
git fetch --all
TAG=$(git describe --tags "$(git rev-list --tags --max-count=1)" 2>&1)

if [[ "${IS_RELEASE}" == "true" ]]; then
  export VERSION="$TAG"
  echo "Publishing Release: $VERSION"
else
  export VERSION="${TAG}.${BUILD_NR}-SNAPSHOT"
  echo "Publishing Snapshot: $VERSION"
fi

# Publish
"${REPO_DIR}"/gradlew build publish
