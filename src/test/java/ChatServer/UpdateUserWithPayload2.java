package ChatServer;

import io.restassured.RestAssured;

import static PayLoad.ChatServerPayload.updateChatUser;
import static io.restassured.RestAssured.given;

public class UpdateUserWithPayload2 {

    public static void main(String[] args) {

        RestAssured.baseURI="http://localhost:80/chat/lhc_web/index.php/site_admin";

        String username = "nitin111";
        String password = "nitin111";
        String email = "nitin@yahoo.com";
        String name = "nitin";
        String surname = "G";
        String nickName = "nitin11";



        int userId = 92;
        String respUpdateUser = given().log().all().
                auth().preemptive().basic("admin", "admin123")
                .body(updateChatUser(username,password,email,name,surname,nickName))
                .when().put("/restapi/user/"+userId)
                .then().log().all().assertThat().statusCode(200).extract().asString();

        System.out.println(respUpdateUser);


    }
}
