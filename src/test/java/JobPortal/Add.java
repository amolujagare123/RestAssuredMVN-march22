package JobPortal;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Add {
    @Test
    public void addJob()
    {
        RestAssured.baseURI = "http://localhost:9897/";

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
                .then().log().all().assertThat().statusCode(201);
    }
}
