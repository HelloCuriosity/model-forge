.PHONY: all build clean coverage format lint publish test

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

publish:
	./scripts/publish.sh ${GITHUB_RUN_NUMBER}

test:
	./gradlew test
