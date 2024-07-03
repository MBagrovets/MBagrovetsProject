package com.itacademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy (id = "loginFormLoginEmailLink")
    private WebElement emailTab;

    @FindBy (xpath = "//*[text()= 'Войти']")
    private WebElement signInBtn;

    @FindBy(xpath = "//*[@class = 'i-popover__line']")
    private WebElement redError;

    @FindBy (xpath = "//*[@class = 'i-input i-input_full-width i-input_with-padding i-popup__input']")
    private WebElement passwordField;

    @FindBy (xpath = "//*[@tabindex = '1'] [@name = 'cl_email']")
    private WebElement emailField;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickEmailTab(){
        emailTab.click();
    }

    public void clickSignInBtn(){
        signInBtn.click();
    }

    public WebElement getRedError(){
        return redError;
    }

    public WebElement getPasswordField(){
        return passwordField;
    }

    public WebElement getEmailField(){
        return emailField;
    }
}
