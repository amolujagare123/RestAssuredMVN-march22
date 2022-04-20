package ChatServer;

import POJO.AddMsgAsAdminPOJO;
import POJO.AutoLoginPOJO;
import POJO.Msg;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MsgByAdminUsingPOJO {

    @Test
    public void sendRequest() {

        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        Msg msg = new Msg();
        msg.setMsg("this is message by admin");
        msg.setMeta_msg("by admin");
        msg.setId(0);
        msg.setChat_id(1230);
        msg.setTime(10);

        AddMsgAsAdminPOJO addMsgAsAdminPOJO = new AddMsgAsAdminPOJO();
        addMsgAsAdminPOJO.setMsg(msg);
        addMsgAsAdminPOJO.setR("String");
        addMsgAsAdminPOJO.setError(false);


        given().log().all().
                auth().preemptive().basic("admin", "admin123")
                .header("Content-Type","application/json")
                .body(addMsgAsAdminPOJO)
                .when().post("/restapi/addmsgadmin")
                .then().log().all().assertThat().statusCode(400);
    }

}
