package SampleRequest;

import io.restassured.RestAssured;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static PayLoad.SampleRequest.createUserPayLoad;
import static io.restassured.RestAssured.given;

public class SampleCreateUserPayloadJSON {

    public static void main(String[] args) throws IOException {

        RestAssured.baseURI= "https://reqres.in";

        given().log().all().header("Content-Type","application/json")
                .body(new String(Files.readAllBytes(Paths.get("D:\\Study\\API-data\\createSampleUserPayload.json"))))
                .when().post("/api/users")
                .then().log().all().statusCode(201);
    }
}
