package DeckOfCards;

import POJO.Response.Cards;
import POJO.Response.DrawCardsResponse;
import POJO.Response.ShuffleCardsResponse;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ShuffleCardsPojoResponse {

    public static void main(String[] args) {

        RestAssured.baseURI="https://deckofcardsapi.com/";

        ShuffleCardsResponse shuffleCardsResponse = given().log().all().queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().assertThat().statusCode(200)
                .body("success", equalTo(true))
                .body("remaining", equalTo(52)).extract().as(ShuffleCardsResponse.class);
        System.out.println("Below is the response extracted");



        String deckId = shuffleCardsResponse.getDeck_id();

        System.out.println("Deck Id="+deckId);


        DrawCardsResponse drawCardsResponse = given().log().all().queryParam("count", "2")
                .when().get("/api/deck/" + deckId + "/draw/")
                .then().log().all().assertThat().statusCode(200)
                .body("remaining", equalTo(50)).extract().as(DrawCardsResponse.class);


        Cards cardDetails = drawCardsResponse.getCards().get(0);

        System.out.println(cardDetails.getCode());
        System.out.println(cardDetails.getImage());


     /*   given().log().all().queryParam("remaining","true")
                .when().get("/api/deck/"+deckId+"/shuffle/")
                .then().log().all().assertThat().statusCode(200)
        .body("deck_id",equalTo(deckId));*/

    }
}
