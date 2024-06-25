package com.itacademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;


public class HomePage {
    private WebDriver driver;

    @FindBy (xpath = "//*[@placeholder = 'Введите название товара']")
    private WebElement searchBox;

    @FindBy (xpath = "//button[@class = 'search-form__submit']")
    private WebElement findElement;

    @FindBy (xpath = "//a[@class = 'digi-product__label']")
    private List<WebElement> results;

    @FindBy (xpath = "//*[@class = 'link user-bar__item']")
    private WebElement LoginPageBtn;




    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void typeSearchBox(String text){
        searchBox.click();
        searchBox.sendKeys(text);
    }

    public void clickFindElementBtn(){
        findElement.click();
    }

    public List <String> getResults(){
        return results.stream().map(k->k.getText().toLowerCase()).collect(Collectors.toList());
    }

    public void clickLoginPageBtn(){
        LoginPageBtn.click();
    }

}
