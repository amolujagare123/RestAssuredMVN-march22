package SampleRequest;

import io.restassured.RestAssured;

import static PayLoad.SampleRequest.createUserPayLoad;
import static io.restassured.RestAssured.given;

public class SampleCreateUserPayload {

    public static void main(String[] args) {

        RestAssured.baseURI= "https://reqres.in";

        given().log().all().header("Content-Type","application/json")
                .body(createUserPayLoad())
                .when().post("/api/users")
                .then().log().all().statusCode(201);
    }
}
