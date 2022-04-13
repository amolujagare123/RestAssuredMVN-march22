package SampleRequest;

import io.restassured.RestAssured;

import static PayLoad.SampleRequest.updateUserPayload;
import static io.restassured.RestAssured.given;

public class UpdateUserPayLoad2 {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";

        String userID="2";
        String name = "Vipin";
        String job = "Developer";
             given().log().all().
                header("Content/Type","application/json")
                .body(updateUserPayload(name,job))
                .when().put("/api/users/"+userID)
                .then().log().all().assertThat().statusCode(200);
    }
}
