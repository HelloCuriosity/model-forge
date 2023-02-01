#!/usr/bin/env bash

set -o pipefail

RELEASE_TYPE=${1}

NEW_RELEASE=$(./scripts/get_next_version.sh "$RELEASE_TYPE")

echo "Bumping version to $NEW_RELEASE"

gh release create "$NEW_RELEASE" --target "main" --generate-notes
