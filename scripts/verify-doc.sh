#!/usr/bin/env bash

set -o pipefail

RELEASE_TYPE=${1}
FILE=${2}

VERSION=$(./scripts/get_next_version.sh "$RELEASE_TYPE")

echo "Verifying version $VERSION is defined in: $FILE."
if grep -R "$VERSION" "$FILE"; then
  echo "Version info found."
  exit 0
else
  echo "Version info not found in: $FILE"
  exit 1
fi
