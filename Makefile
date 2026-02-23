BUMP ?= patch
FILE ?= empty

all: clean format lint lint-docs test coverage build docs
.PHONY: all

build:
	./gradlew build
.PHONY: build

clean:
	./gradlew clean
.PHONY: clean

coverage:
	./gradlew koverHtmlReport koverXmlReport ${GRADLE_ARGS}
.PHONY: coverage

docs:
	./gradlew dokkaGenerateHtml
.PHONY: docs

format:
	./gradlew formatKotlin
.PHONY: format

lint:
	./gradlew lintKotlin detekt
.PHONY: lint

local:
	./gradlew build publishToMavenLocal
.PHONY: local

publish:
	./scripts/publish.sh ${GITHUB_RUN_NUMBER}
.PHONY: publish

test:
	./gradlew test
.PHONY: test

verify-doc:
	./scripts/verify-doc.sh ${BUMP} ${FILE}
.PHONY: verify-doc

# Website
build-docs:
	(cd website/ && yarn build)
.PHONY: build-docs

lint-docs:
	npx docusaurus-mdx-checker
.PHONY: lint-docs

install-docs:
	(cd website/ && yarn install)
.PHONY: install-docs

start-docs:
	(cd website/ && yarn start)
.PHONY: start-docs

upgrade-docs:
	(cd website/ && yarn upgrade @docusaurus/core@latest @docusaurus/preset-classic@latest @docusaurus/module-type-aliases@latest)
.PHONY: upgrade-docs
