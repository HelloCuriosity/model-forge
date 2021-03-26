.PHONY: all build clean lint unit-test

all: clean lint unit-test build

build:
	./gradlew build

clean:
	./gradlew clean

coverage:
	./gradlew jacocoTestReport

lint:
	./gradlew lintKotlin detekt --stacktrace

unit-test:
	./gradlew test
