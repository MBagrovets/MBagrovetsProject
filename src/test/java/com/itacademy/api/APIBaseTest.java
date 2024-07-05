package com.itacademy.api;

import com.itacademy.listeners.LocalListener;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(LocalListener.class)
public class APIBaseTest {

    @BeforeMethod
    public static void APISetUp(){
        RestAssured.baseURI = "https://oz.by/";
    }
}
