# OrangeHRM UI Automation Framework

## Project Overview
This project is a Java-based test automation framework designed to verify the User Management functionality of the OrangeHRM application. The framework follows the Page Object Model (POM) design pattern to ensure script maintainability and reduce code duplication. It automates a complete end-to-end flow, including logging in, adding a new user, searching for the user, deleting the user, and logging out.

## Tech Stack
* **Language:** Java 21
* **Automation Library:** Selenium WebDriver 4.18.1
* **Testing Framework:** TestNG 7.10.2
* **Build Tool:** Maven
* **Utilities:** Custom Explicit Wait Synchronization

## Framework Features
* **Page Object Model (POM):** Each web page is represented as a class, separating the page locators from the test logic.
* **Synchronization:** Utilizes a dedicated WaitUtils class to handle asynchronous page behavior and dynamic element loading.
* **Stability:** Optimized locators using relative XPaths based on field labels to prevent test failures caused by UI changes.
* **Data-Driven:** Configured with TestNG DataProviders for parameterized execution.

## Getting Started

### Prerequisites
Before setting up the project, ensure the following software is installed and configured on your system:
* **JDK 21** or higher.
* **Apache Maven** (ensure the 'bin' folder is added to your system environment variables).
* **Google Chrome** browser.

### Installation
1. Clone the repository to your local machine:
   ```bash
   git clone  (https://github.com/MahmoudKhaled95/orangehrm-automation).git]
2. Navigate to the project root directory:
   ```bash
    cd orangehrm-automation
3. Install the required project dependencies:
   ```bash
   mvn clean install## Project Structure
### Execution
 
To run the automated test suite from the terminal, use the following Maven command:
       ```bash
       
       mvn UserTest

```text
src/
├── main/
│   └── java/
│       ├── base/
│       │   └── BaseTest.java        # Browser setup and configuration
│       ├── pages/
│       │   ├── LoginPage.java       # Login page actions
│       │   ├── DashboardPage.java   # Navigation and logout methods
│       │   ├── AdminPage.java       # User search and deletion logic
│       │   └── AddUserPage.java     # User creation form handling
│       └── utils/
│           └── WaitUtils.java       # Explicit wait synchronization
└── test/
    └── java/
        └── tests/
            └── UserTest.java        # End-to-end test execution


