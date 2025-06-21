OrangeHRM Automated Test Suite

🧪 Overview

This project provides a comprehensive suite of automated end-to-end tests for the OrangeHRM human resource management application. Designed with scalability and maintainability in mind, the suite ensures the reliability of core functionalities in Admin, PIM, and Leave Management modules.

🚀 Features Covered

✅ Admin login/logout workflows

✅ Add/Edit/Delete Admin users

✅ Admin user search functionality

✅ Add/Edit/Delete Employee records via PIM module

✅ Add ESS (Employee Self-Service) users

✅ Manage leave entitlements

✅ Login validation for ESS users




🛠️ Technology Stack

Technology                     Description
------------------------------------------------------------------------------
Java                           Programming language for test implementation

Selenium WebDriver              UI automation framework

TestNG                         Testing framework for organizing and executing tests

ChromeDriver                   WebDriver for Google Chrome

Maven                         Build tool for dependency management


📁 Project Structure

orangHrmTest/

├── AppTest.java       # Core test suite with all automated test cases

├── testData.java      # Dynamic test data generation and WebDriver setup

├── README.md          # Project documentation



⚙️ Setup Instructions

Prerequisites

-Java JDK 8+

Google Chrome installed

-ChromeDriver added to system PATH

-IDE (e.g., IntelliJ IDEA, Eclipse)



Installation & Execution

1. Clone the repository:

- git clone https://github.com/AmerMoNa/orangeHRM.git

2. Open in your IDE and ensure dependencies (Selenium & TestNG) are added.

3. Run tests:

- Right-click AppTest.java → Run as TestNG Suite

💡 The test suite uses randomized usernames and IDs to prevent data collisions and simulate real-world usage.



🧩 Test Data Management

The testData.java class handles:

-Centralized test credentials and personal info

-Randomized ID and name generation

-WebDriver initialization and configuration



✅ Best Practices Applied

Modular and reusable code architecture

Synchronization with implicit waits

Assertions for validation

Structured naming conventions and readability



📌 Future Enhancements

Integration with CI/CD tools (e.g., GitHub Actions, Jenkins)

Page Object Model (POM) refactor

Advanced reporting with Allure or ExtentReports



👤 Author

Amer Mohammad Nawasreh

📍 Computer Engineering

💼 QA Engineer | Test Automation Enthusiast

🔗 Amer Mohammad Nawasreh - LinkedIn

📧 Email: amnawasreh2@gmail.com