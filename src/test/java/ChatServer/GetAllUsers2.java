package ChatServer;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetAllUsers2 {

    public static void main(String[] args) {

        RestAssured.baseURI="http://localhost:80/chat/lhc_web/index.php/site_admin";

        String repGetAllUsers = given().log().all().auth().
                preemptive().basic("admin","admin123")
                .when().get("/restapi/getusers")
                .then().log().all().assertThat().statusCode(200).
                body("error", equalTo(false)).extract().response().asString();

        JsonPath jsonRespGetAllUsers = new JsonPath(repGetAllUsers);

        String userName0 = jsonRespGetAllUsers.getString("result[0].username");
        int disabled = jsonRespGetAllUsers.getInt("result[0].disabled");

        System.out.println("userName0="+userName0);
        System.out.println("disabled="+disabled);

        int size = jsonRespGetAllUsers.getInt("result.size()");

        System.out.println("Total users = "+size);

    }
}
