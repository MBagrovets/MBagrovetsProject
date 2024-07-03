# MBagrovetsProject

## Project for OZ.BY - online store selling books and other products. Courier delivery of goods and pick-up from stores.

### AQA - Marina Bagrovets

### Description:
This project contains a set of automated tests written in Java for testing a web application. The tests use **TestNG** for test management, **RestAssured** framework for API testing, and **Selenium WebDriver** for UI testing.

### Content:
- **src:**
    - **listeners package:**


    **LocalListener** - class for Listeners that use Loggers.
- **pages package:**


    **HomePage** - class for Page Factory, locators on the current page and for their methods and constructors.


    **LoginPage** - class for Page Factory, locators on the current page and for their methods and constructors.
- **resources:**


    **log4j2.properties** - for using Loggers.

- **test:**
    - **API package:**


    **APIBaseTest** - base test for APITests. Contains Before Method.


    **APITest** - for API Tests.
- **UI package:**


    **UIBaseTest** - base test for UITests. Contains Before and After Methods.


    **UITest** - for UI Tests.
- **resources:**
    - **testsuites package:**


      **APIsuite** - .xml file for API tests.


      **UIsuite** - .xml file for UI tests.
    - **allure.properties** - for using Allure Report.


