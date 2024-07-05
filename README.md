Project for OZ.BY - online store selling books and other products. Courier delivery of goods and pick-up from stores.
AQA - Marina Bagrovets

Description:
This project contains a set of automated tests written in Java for testing a web application. The tests use **TestNG** for test management, **RestAssured** framework for API testing, and **Selenium WebDriver** for UI testing.

Content:
- **src:**
  - listeners package:
1. LocalListener - class for Listeners that use Loggers.
  - pages package:
2. HomePage - class for Page Factory, locators on the current page and for their methods and constructors.
3. LoginPage - class for Page Factory, locators on the current page and for their methods and constructors.
  - resources:
4. log4j2.properties** - for using Loggers.
 
- **test:**
  - API package:
5. APIBaseTest - base test for APITests. Contains Before Method.
6. APITest - for API Tests.
  - UI package:
7. UIBaseTest** - base test for UITests. Contains Before and After Methods.
8. UITest** - for UI Tests.
  - resources:
    - testsuites package:
9. APIsuite** - .xml file for API tests.
10. UIsuite** - .xml file for UI tests.

    - 11. - allure.properties - for using Allure Report.