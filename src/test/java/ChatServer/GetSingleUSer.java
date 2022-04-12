package ChatServer;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetSingleUSer {

    public static void main(String[] args) {

        RestAssured.baseURI="http://localhost:80/chat/lhc_web/index.php/site_admin";

        int userId=5;
        given().log().all().auth().
                preemptive().basic("admin","admin123")
                .when().get("/restapi/user/"+userId)
                .then().log().all().assertThat().statusCode(200)
              //  .time(Matchers.lessThan(600L))
             //   .time(Matchers.greaterThanOrEqualTo(1000L));
        .time(Matchers.both(Matchers.greaterThanOrEqualTo(400L))
        .and(Matchers.lessThanOrEqualTo(600L)));

        // response time


    }
}
