package ChatServer;

import POJO.AutoLoginPOJO;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AutoLoginUsingPOJO {

    @Test
    public void sendRequest() {

        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        AutoLoginPOJO obj = new AutoLoginPOJO();

        obj.setU(1);
        obj.setL("admin");
        obj.setR("front/default");
        obj.setT(60);

        given().log().all().
                auth().preemptive().basic("admin", "admin123")
                .header("Content-Type","application/json")
                .body(obj)
                .when().post("/restapi/generateautologin")
                .then().log().all().assertThat().statusCode(400);
    }

}
