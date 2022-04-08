package SampleRequest;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class DeleteUser {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in";

        String userId = "2";

        given().log().all().when().delete("/api/users/"+userId)
                .then().log().all().assertThat().statusCode(204);
    }
}
