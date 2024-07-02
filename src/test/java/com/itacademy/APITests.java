package com.itacademy;

import com.itacademy.listeners.LocalListener;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
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

@Listeners(LocalListener.class)
public class APITests {

    private static final Logger LOGGER = LogManager.getLogger(APITests.class);

    @Test
    public void getBooks(){
        Response response = RestAssured.given().log().all()
                .when().get("https://oz.by/books/")
                .then().log().all().statusCode(200)
                .extract().response();
        String html = response.asString();
        Document document = Jsoup.parse(html);

        Elements bookElements = document.select(".link.product-card__link");
        Assert.assertTrue(bookElements != null && !bookElements.isEmpty(), "The list of book elements should not be empty");


        for (Element bookElement : bookElements) {    // текстовое содержимое элемента. нужно будет удалить!!!!!!!!!!!
            System.out.println(bookElement.text());
        }
    }

    @Test
    public void basicAuthentification() {
        given()
                .auth().basic("m.bagrovets.qa@gmail.com", "MkU85g")
                .when().get("https://oz.by/checkout/")
                .then().statusCode(200).log().all();

    }

    @Test
    public void jsonSchema() {
        RestAssured.baseURI = "https://oz.by/";
        given().log().all()
                .when().get("/books")
                .then().log().all().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("json/jsonschema.json"));
    }


}
