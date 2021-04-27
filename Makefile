SONATYPE_USER ?= not set
SONATYPE_PASSWORD ?= not set
PGP_SIGNING_KEY ?= not set
PGP_SIGNING_PASSWORD ?= not set

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
	./scripts/publish.sh ${SONATYPE_USER} ${SONATYPE_PASSWORD} ${PGP_SIGNING_KEY} ${PGP_SIGNING_SONATYPE_PASSWORD}

unit-test:
	./gradlew test
