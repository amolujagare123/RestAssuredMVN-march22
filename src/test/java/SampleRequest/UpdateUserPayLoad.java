package SampleRequest;

import io.restassured.RestAssured;

import static PayLoad.SampleRequest.updateUserPayload;
import static io.restassured.RestAssured.given;

public class UpdateUserPayLoad {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";

        String userID="2";
             given().log().all().
                header("Content/Type","application/json")
                .body(updateUserPayload())
                .when().put("/api/users/"+userID)
                .then().log().all().assertThat().statusCode(200);
    }
}
