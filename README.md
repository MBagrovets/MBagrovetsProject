Project for OZ.BY - online store selling books and other products. Courier delivery of goods and pick-up from stores.
AQA - Marina Bagrovets

Description:
This project contains a set of automated tests written in Java for testing a web application. 
Used in the project: 
**TestNG** for test management, 
**RestAssured** framework for API testing, 
**Selenium WebDriver** for UI testing, 
**Allure Report** for report creating, 
**ScreenShotUtills** for screenhots creating and saving, 
**Maven** for automatic building of projects, 
**Log4j2** for logs generating

Content:
**main:**
  **- listeners package**:
1. LocalListener - class for Listeners that use Loggers.
  **- pages package**:
2. HomePage - class for Page Factory, locators on the current page and for their methods and constructors.
3. LoginPage - class for Page Factory, locators on the current page and for their methods and constructors.
   **- utils**:
4. TakeScreenshotUtil - class for the method that is used to take screenshots.
5. Waiters - class for the method that is used to take Waiters.
  **- resources**:
6. log4j2.properties - for using Loggers.
 
**test:**
  **- API package**:
7. APIBaseTest - base test for APITests. Contains Before Method.
8. APITest - for API Tests.
  **- UI package**:
9. UIBaseTest - base test for UITests. Contains Before and After Methods.
10. UITest - for UI Tests.
  **- resources**:
    a - testsuites package:
11. APIsuite - .xml file for API tests.
12. UIsuite - .xml file for UI tests. 

b -  13. - allure.properties - file for using Allure Report.