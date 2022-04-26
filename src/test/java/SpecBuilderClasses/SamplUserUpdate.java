package SpecBuilderClasses;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class SamplUserUpdate {

    @Test
    public void updateUser()
    {
        RequestSpecification reqSpec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .addHeader("Content-Type", "application/json")
                .build();

        RequestSpecification request = given().log().all().spec(reqSpec).body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}");

        ResponseSpecification respSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody("job", equalTo("zion resident"))
                .build();

        Response response = request.when().put("/api/users/2");

        String myResponse = response.then().log().all().spec(respSpec).extract().asString();

        System.out.println(myResponse);
    }
}
