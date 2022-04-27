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

public class JobPortalAdd {
    @Test
    public void addJob()
    {
       /* RestAssured.baseURI = "http://localhost:9897/";

        given().log().all().header("Content-Type","application/json")
                .body("{\n" +
                        "  \"experience\": [\n" +
                        "    \"3 years\"\n" +
                        "  ],\n" +
                        "  \"jobDescription\": \"Automation testing\",\n" +
                        "  \"jobId\": 0,\n" +
                        "  \"jobTitle\": \"Test Lead\",\n" +
                        "  \"project\": [\n" +
                        "    {\n" +
                        "      \"projectName\": \"Job portal\",\n" +
                        "      \"technology\": [\n" +
                        "        \"PHP\"\n" +
                        "      ]\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when().post("/normal/webapi/add")
                .then().log().all().assertThat().statusCode(201);*/

        RequestSpecification reqSpec = new RequestSpecBuilder()
                .setBaseUri("http://localhost:9897/")
                .addHeader("Content-Type", "application/json")
                .build();

        RequestSpecification request = given().log().all().spec(reqSpec).body("{\n" +
                "  \"experience\": [\n" +
                "    \"3 years\"\n" +
                "  ],\n" +
                "  \"jobDescription\": \"Automation testing\",\n" +
                "  \"jobId\": 0,\n" +
                "  \"jobTitle\": \"Test Lead\",\n" +
                "  \"project\": [\n" +
                "    {\n" +
                "      \"projectName\": \"Job portal\",\n" +
                "      \"technology\": [\n" +
                "        \"PHP\"\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}");

        Response response = request.when().post("/normal/webapi/add");

        ResponseSpecification respSpec = new ResponseSpecBuilder().expectStatusCode(201)
                .expectBody("jobDescription", equalTo("Automation testing"))
                .build();

        String myResponse = response.then().log().all().spec(respSpec).extract().asString();

        System.out.println(myResponse);
    }
}
