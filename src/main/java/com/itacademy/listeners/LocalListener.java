package com.itacademy.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class LocalListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("========================================");
        System.out.println("Test "+ result.getMethod().getMethodName()+" started");
        System.out.println("========================================");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("========================================");
        System.out.println("Test "+ result.getMethod().getMethodName()+" passed");
        System.out.println("========================================");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("========================================");
        System.out.println("Test "+ result.getMethod().getMethodName()+" failed");
        System.out.println("========================================");
    }
}