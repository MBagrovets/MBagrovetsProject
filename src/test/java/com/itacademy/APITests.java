package com.itacademy;

import com.itacademy.listeners.LocalListener;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

@Listeners(LocalListener.class)
public class APITests {

    private static final Logger LOGGER = LogManager.getLogger(APITests.class);

    @Test
    public void getBooks(){
        RestAssured.baseURI = "https://oz.by/";
        Response response = RestAssured.given().log().all()
                .when().get("books/")
                .then().log().all().statusCode(200)
                .extract().response();
        String html = response.asString();
        Document document = Jsoup.parse(html);

        Elements bookElements = document.select(".link.product-card__link");
        Assert.assertTrue(bookElements != null && !bookElements.isEmpty(), "The list of book elements should not be empty");

        for (Element bookElement : bookElements) {
            LOGGER.info(bookElement.text());
        }
    }

    @Test
    public void basicAuthentification() {
        RestAssured.baseURI = "https://oz.by/";
        given()
                .auth().basic("m.bagrovets.qa@gmail.com", "MkU85g")
                .when().get("checkout/")
                .then().statusCode(200).log().all();
    }

    @Test
    public void loginWithInvalidCredentials(){
        RestAssured.baseURI = "https://auth.oz.by/";
        given().log().all()
                .contentType(JSON)
                .body("{\n" +
                        "    \"cl_email\": \"111@gmail.com\",\n" +
                        "    \"cl_psw\": \"111\"\n" +
                        "}")
                .when().post("index.phtml?action=loginByProvider")
                .then().log().all().statusCode(302);
    }



}
