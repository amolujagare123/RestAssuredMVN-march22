package ChatServer;

import io.restassured.RestAssured;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static PayLoad.ChatServerPayload.createChatUser;
import static io.restassured.RestAssured.given;

public class CreateUserPayloadJSON {

    public static void main(String[] args) throws IOException {

        RestAssured.baseURI="http://localhost:80/chat/lhc_web/index.php/site_admin";

        String respCreateUser = given().log().all().
                auth().preemptive().basic("admin", "admin123")
                .body(new String(Files.readAllBytes(Paths.get("D:\\Study\\API-data\\chatServerCreateUser.json"))))
                .when().post("/restapi/user")
                .then().log().all().assertThat()./*statusCode(200).*/extract().asString();

        System.out.println(respCreateUser);



    }
}
