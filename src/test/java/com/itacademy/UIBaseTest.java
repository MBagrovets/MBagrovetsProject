package com.itacademy;

import com.itacademy.listeners.LocalListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(LocalListener.class)
public class UIBaseTest {

    protected static WebDriver driver;

    @BeforeMethod

    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/SeleniumServer/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get ("https://oz.by/");
    }

    @AfterMethod
    public void stopDriver(){
        if (driver != null){
            driver.quit();
        }
    }
}
