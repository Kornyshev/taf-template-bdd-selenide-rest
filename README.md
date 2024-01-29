# Test Automation Framework (TAF) Template

## Introduction

This repository contains a Java-based Test Automation Framework (TAF) template, focusing on both UI and API testing. It utilizes Cucumber for behavior-driven development (BDD) and includes three basic yet fully functional scenarios. The template serves as a starting point for automation projects, offering a structured foundation with necessary configurations and basic examples.

## Features

- **Cucumber Integration**: Enables writing and executing tests in BDD style.
- **Java 17 Compatibility**: Ensures compatibility with modern Java features.
- **Page Object Model (POM)**: Implements POM for efficient UI test maintenance.
- **API Testing Support**: Setup included for RESTful API testing.
- **Allure Reporting**: Integrated for comprehensive test reporting.
- **Selenide for UI Testing**: Simplifies UI test automation.
- **JUnit 5**: Supports advanced unit testing features.

## Dependencies Overview

- **JUnit 5 (v5.9.2)**
- **Cucumber (v7.2.3)**
- **Allure (v2.17.3)**
- **Selenide (v6.17.2)**
- **Rest-Assured (v5.3.0)**
- **SLF4J and Logback**
- **Jackson, Commons-DBUtils, Awaitility, AssertJ, Lombok**

## Prerequisites

- Java 17
- Maven

## Setup and Installation

1. Clone the Repository: `git clone [repository-url]`
2. Navigate to the project directory: `cd taf-template-empty`
3. Install Dependencies: `mvn clean install`

## Writing Tests

### Structure

- **Feature Files**: `src/test/resources/features`
- **Step Definitions**: `src/main/java/org/example/steps`
- **Page Objects**: `src/main/java/org/example/fe`

### Creating a New Test

1. Define a scenario in a feature file.
2. Create step definitions in Java.
3. Run tests using Maven or an IDE.

## Running Tests

- Run `mvn test` to execute all tests.
- Results and logs are in the `target` directory.

## Reporting

- Generate Allure reports using `mvn allure:serve`.
