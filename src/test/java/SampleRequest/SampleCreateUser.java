package SampleRequest;

import POJO.Response.CreateUserResponse;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class SampleCreateUser {

    public static void main(String[] args) {

        RestAssured.baseURI= "https://reqres.in";

        CreateUserResponse response = given().log().all().header("Content-Type","application/json")
                .body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}")

                .when().post("/api/users")
                .then().log().all().statusCode(201).extract().as(CreateUserResponse.class);


        System.out.println("name="+response.getName());

        System.out.println("job="+response.getJob());

        System.out.println("id="+response.getId());

        System.out.println("created at="+response.getCreatedAt());


        // System.out.println(response);
    }
}
