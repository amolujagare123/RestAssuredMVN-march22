package DeckOfCards;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ShuffleCards {

    public static void main(String[] args) {

        RestAssured.baseURI="https://deckofcardsapi.com/";

        String shuffleCardsResponse = given().log().all().queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().assertThat().statusCode(200)
                .body("success", equalTo(true))
                .body("remaining", equalTo(52)).extract().response().asString();

        System.out.println("Below is the response extracted");
        System.out.println(shuffleCardsResponse);

        JsonPath jsonShuffleCards = new JsonPath(shuffleCardsResponse);

        String deckId = jsonShuffleCards.getString("deck_id");

        System.out.println("Deck Id="+deckId);


        given().log().all().queryParam("count","2")
                .when().get("/api/deck/"+deckId+"/draw/")
                .then().log().all().assertThat().statusCode(200)
        .body("remaining",equalTo(50));

        // reshuffle cards -> https://deckofcardsapi.com/api/deck/<<deck_id>>/shuffle/
        //https://deckofcardsapi.com/api/deck/<<deck_id>>/shuffle/?remaining=true

        given().log().all().queryParam("remaining","true")
                .when().get("/api/deck/"+deckId+"/shuffle/")
                .then().log().all().assertThat().statusCode(200)
        .body("deck_id",equalTo(deckId));

    }
}
