package SampleRequest;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class ListAUser {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in";

      /*  given().log().all().when().get("/api/users/2")
                .then().log().all().assertThat().statusCode(200);*/

        String userID = "3";

        given().log().all().when().get("/api/users/"+userID)
                .then().log().all().assertThat().statusCode(200);





    }
}
