# Contributing

:rocket: Thanks for showing your interest and taking the time to contribute :rocket:

The following is a set of guidelines for contributing to this project. These are guidelines not rules, so feel free to
propose changes to this document via a pull request.

## Table of Contents

* [Quick Start](#quick-start)
* [Code Style Guidelines](#code-style-guidelines)
* [Work with feature branches](#work-with-feature-branches)
* [Testing](#testing)
    * [Running Tests](#running-tests)

## Quick start

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## Code Style Guidelines

Code style is driven by the `kotlinter` and `detekt` if it doesn't adhere to it your build will break. You can run
analysis with:

    $ make lint

## Work with Feature Branches

While developing create feature branches from main. A good rule of thumb is to prefix them with one of the following:

* feature/...
* enhancement/...
* fix/...

## Testing

Tests are imperative to the success and quality of any feature, regardless of its size. It is essential to the
development process, which not only speeds up the development of further features, but works as a safe guard protecting
existing and already tested code.

`Features aren't ready or finished before tests are written.`

### Running Tests

You can run tests with:

    $ make unit-test
