package SpecBuilderClasses;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class SampleUserCreate {

    @Test
    public void testAddUser() {

       /* RestAssured.baseURI = "https://reqres.in";

        given().log().all().header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")
                .when().post("/api/users")
                .then().log().all().statusCode(201);*/

        RequestSpecification reqSpec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .addHeader("Content-Type", "application/json")
                .build();

        RequestSpecification request = given().log().all().spec(reqSpec).body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}");


        ResponseSpecification respSpec = new ResponseSpecBuilder().expectStatusCode(201)
                .expectBody("name", equalTo("morpheus"))
                .build();


        Response response = request.when().post("/api/users");

        String myResponse = response.then().log().all().spec(respSpec).extract().asString();

        System.out.println(myResponse);

    }
}
