---
sidebar_position: 4
---

# Changelog

## [1.5.1] - December 5th 2024

* Support Kotlin version 2.0.0
* Re-enable support for java 17

## [1.5.0] - October 31st 2024

* Auto generation for additional types:
    * UByte
    * UInt
    * ULong
    * UShort
* Dependency updates

## [1.4.0] - February 19th 2024

* Support Kotlin version 1.9.22
* Dependency updates

## [1.3.0] - February 2nd 2023

* Support Kotlin version 1.8.0
* Dependency updates

## [1.2.0] - November 12th 2022

* Add missing tests for sets
* Added asserts for types in tests
* Docusaurus website
* Workflow dependency updates

## [1.1.0] - October 5th 2022

* Dependency updates
* Housekeeping and general clean up

## [1.0.0] - July 25th 2022

* Auto publishing via CI
* Auto labeling via CI
* Removed deprecated reified functions
* Added missing test for custom char provider
* Added code of conduct
* Minor housekeeping tasks
* Dependency updates

## [0.9.0] - March 22nd 2022

* Support for map collection type.
* Better output message when using `attempt`.
* Removed the custom Provider interface in favor of `javax.inject.Provider`.
    * See [Migration Guide](migration.md) for details.
* Moved dependency definitions to `buildSrc`
* Fixed StringProvider to be more explicit when generating strings.

## [0.8.0] - December 7th 2021

* Auto generation for additional types:
    * Byte
    * Char
    * Short
    * UUID
* Support for Set collection type
* Dependency updates

## [0.7.4] - September 16th 2021

* Build with Java 8

## [0.7.3] - September 15th 2021

* Add GitHub Action dependencies to dependabot
* Dependency updates

## [0.7.2] - July 29th 2021

* Allow for forging Enums directly through ModelForge.build
* Add more Kotlin `Provider<T>` fanciness

## [0.7.1] - June 26th 2021

* Don't instantiate reflective objects when handling custom providers

## [0.7.0] - June 7th 2021

* Added reified inline extension functions

## [0.6.0] - June 3rd 2021

* Exclude Companion Object Values
* Support for File type.

## [0.5.1] - June 1st 2021

* Support for optional variables.

## [0.5.0] - May 30th 2021

* Support for List collection type.
* Support for complex data types.
* Support for custom providers.

## [0.4.0] - May 26th 2021

Auto generation for enums.

## [0.3.0] - May 13th 2021

Auto generation for additional types:

* Calendar
* Instant

## [0.2.0] - May 6th 2021

* Allow using Kotlin class definitions directly.
* Added forgery and forgeries property delegate.

## [0.1.1] - April 30th 2021

* Java 8 compatibility

## [0.1.0] - April 28th 2021

The initial release supports auto generated models for the following types:

* Boolean
* Date
* Double
* Float
* Int
* Long
* String 
