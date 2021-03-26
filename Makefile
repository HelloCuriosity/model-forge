.PHONY: all build clean unit-test

all: clean unit-test build

build:
	./gradlew build

clean:
	./gradlew clean

unit-test:
	./gradlew test
