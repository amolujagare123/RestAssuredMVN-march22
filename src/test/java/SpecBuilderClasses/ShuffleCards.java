package SpecBuilderClasses;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ShuffleCards {

    @Test
    public void shuffleCards()
    {
       /* RestAssured.baseURI="https://deckofcardsapi.com/";

        String shuffleCardsResponse = given().log().all().queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().assertThat().statusCode(200)
                .body("success", equalTo(true))
                .body("remaining", equalTo(52)).extract().response().asString();

        System.out.println("Below is the response extracted");
        System.out.println(shuffleCardsResponse);*/

        RequestSpecification reqSpec = new RequestSpecBuilder()
                .setBaseUri("https://deckofcardsapi.com/")
                .addQueryParam("deck_count", "1").build();

        RequestSpecification request = given().log().all().spec(reqSpec);

        Response response = request.when().get("/api/deck/new/shuffle/");

        ResponseSpecification respSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectBody("success", equalTo(true))
                .expectBody("remaining", equalTo(52))
                .build();

        String myResponse = response.then().log().all().spec(respSpec).extract().asString();
        System.out.println("Below is the response extracted");
        System.out.println(myResponse);
    }
}
