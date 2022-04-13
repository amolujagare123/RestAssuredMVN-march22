package ChatServer;

import io.restassured.RestAssured;

import static PayLoad.ChatServerPayload.updateChatUser;
import static io.restassured.RestAssured.given;

public class UpdateUserWithPayload {

    public static void main(String[] args) {

        RestAssured.baseURI="http://localhost:80/chat/lhc_web/index.php/site_admin";

        int userId = 90;
        String respUpdateUser = given().log().all().
                auth().preemptive().basic("admin", "admin123")
                .body(updateChatUser())
                .when().put("/restapi/user/"+userId)
                .then().log().all().assertThat().statusCode(200).extract().asString();

        System.out.println(respUpdateUser);


    }
}
