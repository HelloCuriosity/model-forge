BUMP ?= patch

.PHONY: all build clean dependencies coverage format lint local publish test version build-docs install-docs start-docs

all: clean format lint test coverage build

build:
	./gradlew build

clean:
	./gradlew clean

coverage:
	./gradlew koverMergedReport

dependencies:
	./gradlew dependencyUpdates

format:
	./gradlew formatKotlin

lint:
	./gradlew lintKotlin detekt

local:
	./gradlew build publishToMavenLocal

publish:
	./scripts/publish.sh ${GITHUB_RUN_NUMBER}

test:
	./gradlew test

version:
	./scripts/create-release.sh ${BUMP}

# Website
build-docs:
	(cd website/ && yarn build)

install-docs:
	(cd website/ && yarn install)

start-docs:
	(cd website/ && yarn start)
