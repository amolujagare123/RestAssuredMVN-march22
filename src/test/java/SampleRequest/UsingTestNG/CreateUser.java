package SampleRequest.UsingTestNG;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUser {

    @Test
    public void createUserRequest()
    {
        RestAssured.baseURI= "https://reqres.in";

        given().log().all().header("Content-Type","application/json")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")

                .when().post("/api/users")
                .then().log().all().statusCode(201);
    }

}
