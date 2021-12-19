# Testing Yandex.Mail
Testing Yandex.Mail with Java, Selenium, TestNG, Gradle.

## Table of content

- [General info](#general-info)
- [Technologies](#technologies)
- [Installation](#installation)
- [Setup](#setup)

## General info

This project contains tests for Yandex.Mail.\
Tests go through **home mail page**, **login page**, and **user mail page**.\
Also tests use chromedriver for **Chrome 96** and generate report using Allure.

## Technologies

Project uses:
- Java 16.0
- Selenium + GRID 5
- TestNG 7.4.0
- Gradle
- Allure Test Report 2.17

## Installation

Clone repo:\
`$ git clone https://github.com/blyoha/selenium-mail-test`

## Setup

Launch gub.bat:\
`$ ./selenium/hub.bat`

Start tests:\
`$ ./gradlew clean test`

## Allure report

Generate report:\
`$ allure generate allure-results --clean`

Open report:\
`$ allure open`