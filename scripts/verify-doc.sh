#!/usr/bin/env bash

set -o pipefail

RELEASE_TYPE=${1}
FILE=${2}

VERSION=$(./scripts/get_next_version.sh "$RELEASE_TYPE")

echo "Verifying file for version: $VERSION"
if grep -R "$VERSION" "$FILE"; then
  echo "Version found"
  exit 0
else
  echo "Version not found"
  exit 1
fi
