#!/usr/bin/env bash

set -o pipefail

RELEASE_TYPE=${1}

# Get current release version
git fetch --force --tags
CURRENT_RELEASE=$(git tag --sort=committerdate | tail -1)

# Separate major, minor and patch numbers
IFS='.' read -r MAJOR MINOR PATCH <<<"$CURRENT_RELEASE"

# $/${} is unnecessary on arithmetic variables.
# shellcheck disable=SC2004
if [[ "${RELEASE_TYPE}" == "major" ]]; then
  NEW_RELEASE="$(($MAJOR + 1)).0.0"
elif [ "${RELEASE_TYPE}" == "minor" ]; then
  NEW_RELEASE="$MAJOR.$(($MINOR + 1)).0"
else
  NEW_RELEASE="$MAJOR.$MINOR.$(($PATCH + 1))"
fi

echo "Bumping version from $CURRENT_RELEASE to $NEW_RELEASE"

gh release create "$NEW_RELEASE" --target "main" --generate-notes
