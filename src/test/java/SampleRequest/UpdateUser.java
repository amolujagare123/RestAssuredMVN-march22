package SampleRequest;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class UpdateUser {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";

        String userID="2";
        String name="Amol";
        String job = "Test Engineer";

        given().log().all().
                header("Content/Type","application/json")
                .body("{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \""+job+"\"\n" +
                "}")
                .when().put("/api/users/"+userID)
                .then().log().all().assertThat().statusCode(200);
    }
}
