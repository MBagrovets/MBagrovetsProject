package com.itacademy.API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import static io.restassured.RestAssured.given;

public class APITests extends APIBaseTest{

    private static final Logger LOGGER = LogManager.getLogger(APITests.class);

    @Test
    public void getBooksTest(){
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
    public void basicAuthentificationTest() {
        given()
                .auth().basic("m.bagrovets.qa@gmail.com", "MkU85g")
                .when().get("checkout/")
                .then().statusCode(200).log().all();
    }

    @Test(priority = 1)
    public void addToCartTest(){
        given().log().all()
                .header("accept", "application/json, text/javascript, */*; q=0.01")
                .header("cookie", "viewtype_Desktop=grid; PHPSESSID=mbmq0h600s5ac5dqngf96mi0bn; _userGUID=0:ly42fswc:bD3PrWjY4cCcryWXaeQwdAZBwrz4mWiS; SID_de664c25=6b5e35f4ca55d777b7eeb206c1bb8b2c; SID_970e2927=6b5e35f4ca55d777b7eeb206c1bb8b2c; cl_pid=33332722; hpid=63120f120cceb7e8521f22bc80bb5442; cl_cpsw=213d91ff8760a066a52bcf979af2232c; subscribeReminderPopup=1; ozby-tkn=f5793675f06d83a3fab9a5582775e3d6; DIGI_CARTID=80145420769; dSesn=b69407ae-d2a3-e031-dd18-4917ab41529a; _dvs=0:ly5j4zdl:1bLKiXtbFykPNzFoJB6sLDNfvou4KKhY; searchStartTime=1719992534689; digi_uc=W1sidiIsIjEwNDA3OTkzIiwxNzE5OTkyNTQyOTUyXV0=")
                .when().get("goods/ajax/html_box.php?idGoods=10407993&type=html&sm=true&searchToken=&secondGoodsFromSet=10967153")
                .then().log().all().statusCode(200).log().all();
    }
    @Test(priority = 2)
    public void deleteFromCartTest(){
        given().log().all()
                .header("accept", "application/json, text/javascript, */*; q=0.01")
                .header("cookie", "viewtype_Desktop=grid; PHPSESSID=mbmq0h600s5ac5dqngf96mi0bn; _userGUID=0:ly42fswc:bD3PrWjY4cCcryWXaeQwdAZBwrz4mWiS; SID_de664c25=6b5e35f4ca55d777b7eeb206c1bb8b2c; SID_970e2927=6b5e35f4ca55d777b7eeb206c1bb8b2c; cl_pid=33332722; hpid=63120f120cceb7e8521f22bc80bb5442; cl_cpsw=213d91ff8760a066a52bcf979af2232c; subscribeReminderPopup=1; ozby-tkn=f5793675f06d83a3fab9a5582775e3d6; dSesn=b69407ae-d2a3-e031-dd18-4917ab41529a; _dvs=0:ly5j4zdl:1bLKiXtbFykPNzFoJB6sLDNfvou4KKhY; searchStartTime=1719992534689; DIGI_CARTID=94785657718; undefined=1")
                .header("content-type","application/x-www-form-urlencoded; charset=UTF-8")
                .body("id_delivery=&id_payment=&payFromCashbackAccount=0&maxAllowedBonusAmountWriteOff=0&hpid=1c275cbb7488393001c28aeba31a47d9_6f42e7e940633f36ac3b52679862fe78&phone=&promo-code=&item%5B%5D=10407993&sale%5B10407993%5D=18947&quantity%5B10407993%5D=1&checkAll=on")
                .when().post("checkout/goods.php?goods")
                .then().log().all().statusCode(200).log().all();
    }
}
