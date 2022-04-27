package SpecBuilderClasses;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class JobPortalGetAllJD {
    @Test
    public void addJob()
    {


        RequestSpecification reqSpec = new RequestSpecBuilder()
                .setBaseUri("http://localhost:9897/")
                .addHeader("Content-Type", "application/json")
                .build();

        RequestSpecification request = given().log().all().spec(reqSpec);

        Response response = request.when().get("/normal/webapi/all");

        ResponseSpecification respSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectBody("[1].jobDescription", equalTo("Automation testing"))
                .build();

        String myResponse = response.then().log().all().spec(respSpec).extract().asString();

        System.out.println(myResponse);
    }
}
