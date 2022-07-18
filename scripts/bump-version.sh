#!/usr/bin/env bash

set -o pipefail

#
git fetch --force --tags
CURRENT_RELEASE=$(git describe --tags "$(git rev-list --tags --max-count=1)" 2>&1)

# Separate major, minor and patch numbers
IFS='.' read -r MAJOR MINOR PATCH <<<"$CURRENT_RELEASE"

RELEASE_TYPE="patch"

# $/${} is unnecessary on arithmetic variables.
# shellcheck disable=SC2004
if [[ "${RELEASE_TYPE}" == "major" ]]; then
  NEW_RELEASE="$(($MAJOR + 1)).$MINOR.$PATCH"
elif [ "${RELEASE_TYPE}" == "minor" ]; then
  NEW_RELEASE="$MAJOR.$(($MINOR + 1)).$PATCH"
else
  NEW_RELEASE="$MAJOR.$MINOR.$(($PATCH + 1))"
fi

echo "Bumping version from $CURRENT_RELEASE to $NEW_RELEASE"

gh release create "$NEW_RELEASE" --target "main" --generate-notes
