package ChatServer;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static PayLoad.ChatServerPayload.createChatUser;
import static io.restassured.RestAssured.given;

public class CreateUserPayload {

    public static void main(String[] args) {

        RestAssured.baseURI="http://localhost:80/chat/lhc_web/index.php/site_admin";

        String respCreateUser = given().log().all().
                auth().preemptive().basic("admin", "admin123")
                .body(createChatUser())
                .when().post("/restapi/user")
                .then().log().all().assertThat()./*statusCode(200).*/extract().asString();

        System.out.println(respCreateUser);



    }
}
