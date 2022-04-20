package SampleRequest.UsingTestNG;

import POJO.CreateUserPOJO;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserUsingPOJO {

    @Test
    public void createUserRequest()
    {
        RestAssured.baseURI= "https://reqres.in";

        CreateUserPOJO ob = new CreateUserPOJO();
        ob.setName("Vipin");
        ob.setJob("Test lead");


        given().log().all().header("Content-Type","application/json")
                .body(ob)

                .when().post("/api/users")
                .then().log().all().statusCode(201);
    }

}
