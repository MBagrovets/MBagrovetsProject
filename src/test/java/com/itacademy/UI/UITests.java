package com.itacademy.UI;

import com.itacademy.pages.HomePage;
import com.itacademy.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class UITests extends UIBaseTest {

    private static final Logger LOGGER = LogManager.getLogger(UITests.class);

    @Test
    public void searchBookTest() throws InterruptedException {

        String fieldName = "философия Java";
        HomePage homePage = new HomePage(driver);

        homePage.typeSearchBox(fieldName.toLowerCase());
        homePage.clickFindElementBtn();
        Thread.sleep(3000);
        List<String> results = homePage.getResults();
        Assert.assertTrue(results.contains(fieldName.toLowerCase()), results + " doesn't have " + fieldName);
    }

    @Test
    public void loginEmailErrorTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        String emailErrorText = "Введите адрес электронной почты";

        homePage.clickLoginPageBtn();
        Thread.sleep(3000);
        loginPage.clickEmailTab();
        loginPage.clickSignInBtn();
        String actualEmailErrorText = loginPage.getRedError().getText();
        Assert.assertEquals(emailErrorText, actualEmailErrorText);
    }

    @Test
    public void loginPasswordErrorTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        String myEmail = "123@gmail.com";
        String passwordErrorText = "Введите пароль";

        homePage.clickLoginPageBtn();
        Thread.sleep(3000);
        loginPage.clickEmailTab();
        loginPage.getEmailField().sendKeys(myEmail);
        loginPage.clickSignInBtn();
        String actualEmailErrorText = loginPage.getRedError().getText();
        Assert.assertEquals(passwordErrorText, actualEmailErrorText);
    }

    @Test
    public void wrongCredentialsTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        String wrongEmail = "w@gmail.com";
        String wrongPassword = "1111";
        String expectedCredentialsErrorText = "Адрес электронной почты не зарегистрирован. Зарегистрироваться";

        homePage.clickLoginPageBtn();
        Thread.sleep(3000);
        loginPage.clickEmailTab();
        loginPage.getEmailField().sendKeys(wrongEmail);
        loginPage.getPasswordField().click();
        loginPage.getPasswordField().sendKeys(wrongPassword);
        loginPage.clickSignInBtn();
        Thread.sleep(2000);
        String actualCredentialsError = loginPage.getRedError().getText();
        Assert.assertEquals(expectedCredentialsErrorText, actualCredentialsError);
    }
}
