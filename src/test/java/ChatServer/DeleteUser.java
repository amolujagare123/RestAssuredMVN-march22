package ChatServer;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteUser {

    public static void main(String[] args) {

        RestAssured.baseURI="http://localhost:80/chat/lhc_web/index.php/site_admin";

        int userId = 89;


        Response response = given().log().all().
                auth().preemptive().basic("admin", "admin123")

                .when().delete("/restapi/user/"+userId);

        response.then().log().all().assertThat().statusCode(200).extract().asString();

    }
}
