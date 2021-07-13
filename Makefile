.PHONY: all build clean coverage format lint local publish test

all: clean format lint test build

build:
	./gradlew build

clean:
	./gradlew clean

coverage:
	./gradlew jacocoTestReport

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
