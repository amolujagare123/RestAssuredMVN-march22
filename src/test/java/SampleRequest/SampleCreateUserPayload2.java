package SampleRequest;

import io.restassured.RestAssured;

import static PayLoad.SampleRequest.createUserPayLoad;
import static io.restassured.RestAssured.given;

public class SampleCreateUserPayload2 {

    public static void main(String[] args) {

        RestAssured.baseURI= "https://reqres.in";

        String name = "Rahul";
        String job = "Manager";

        given().log().all().header("Content-Type","application/json")
                .body(createUserPayLoad(name,job))
                .when().post("/api/users")
                .then().log().all().statusCode(201);
    }
}
