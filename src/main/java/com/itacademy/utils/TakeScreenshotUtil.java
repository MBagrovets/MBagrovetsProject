package com.itacademy.utils;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TakeScreenshotUtil {
    private static final Logger LOGGER = LogManager.getLogger(TakeScreenshotUtil.class);
    @Attachment(value = "Page screenshot", type = "image/png")
    public static String takeScreenshot(WebDriver driver) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        String screenshotPath = date.getTime() + ".png";
        File screenshot = new File(screenshotPath);
        try {
            FileUtils.copyFile(file, screenshot);
        } catch (IOException e) {
            LOGGER.info("Screenshot wasn't saved");
        }
        return screenshotPath;
    }
}
