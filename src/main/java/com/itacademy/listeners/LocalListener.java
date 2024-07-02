package com.itacademy.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LocalListener implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger(LocalListener.class);


    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("========================================");
        LOGGER.info("Test "+ result.getMethod().getMethodName()+" started");
        LOGGER.info("========================================");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("========================================");
        LOGGER.info("Test "+ result.getMethod().getMethodName()+" passed");
        LOGGER.info("========================================");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.info("========================================");
        LOGGER.info("Test "+ result.getMethod().getMethodName()+" failed");
        LOGGER.info("========================================");
    }
}