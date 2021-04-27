.PHONY: all build clean coverage format lint publish unit-test

all: clean format lint unit-test build

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

unit-test:
	./gradlew test
