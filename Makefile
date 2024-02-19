BUMP ?= patch
FILE ?= empty

.PHONY: all build clean dependencies coverage format lint local publish test verify-doc version \
build-docs install-docs start-docs upgrade-docs

all: clean format lint test coverage build

build:
	./gradlew build

clean:
	./gradlew clean

coverage:
	./gradlew koverHtmlReport koverXmlReport ${GRADLE_ARGS}

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

verify-doc:
	./scripts/verify-doc.sh ${BUMP} ${FILE}

version:
	./scripts/create-release.sh ${BUMP}

# Website
build-docs:
	(cd website/ && yarn build)

lint-docs:
	npx docusaurus-mdx-checker

install-docs:
	(cd website/ && yarn install)

start-docs:
	(cd website/ && yarn start)

upgrade-docs:
	(cd website/ && yarn upgrade @docusaurus/core@latest @docusaurus/preset-classic@latest @docusaurus/module-type-aliases@latest)
