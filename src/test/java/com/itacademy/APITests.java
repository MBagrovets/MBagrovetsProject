package com.itacademy;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class APITests {

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


}
