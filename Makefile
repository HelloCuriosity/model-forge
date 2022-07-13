BUMP ?= patch

.PHONY: all build clean dependencies docs coverage format lint local publish start-docs test version

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

start-docs:
	(cd website/ && yarn start)

test:
	./gradlew test

version:
	./scripts/create-release.sh ${BUMP}
