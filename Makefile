.PHONY: all build clean coverage format lint unit-test

all: clean lint unit-test build

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

unit-test:
	./gradlew test
