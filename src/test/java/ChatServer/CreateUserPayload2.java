package ChatServer;

import io.restassured.RestAssured;

import static PayLoad.ChatServerPayload.createChatUser;
import static io.restassured.RestAssured.given;

public class CreateUserPayload2 {

    public static void main(String[] args) {

        RestAssured.baseURI="http://localhost:80/chat/lhc_web/index.php/site_admin";


        String username = "niteen";
        String password = "niteen123";
        String email = "niteen@gmail.com";
        String name = "Niteen";
        String surname = "G";
        String nickName = "niteen1";

        String respCreateUser = given().log().all().
                auth().preemptive().basic("admin", "admin123")
                .body(createChatUser(username,password,email,name,surname,nickName))
                .when().post("/restapi/user")
                .then().log().all().assertThat()./*statusCode(200).*/extract().asString();

        System.out.println(respCreateUser);



    }
}
