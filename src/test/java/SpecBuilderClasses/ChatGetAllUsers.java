package SpecBuilderClasses;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ChatGetAllUsers {

    @Test
    public  void getAllUsers()
    {
  /*      RestAssured.baseURI="http://localhost:80/chat/lhc_web/index.php/site_admin";

        String repGetAllUsers = given().log().all().auth().
                preemptive().basic("admin","admin123")
                .when().get("/restapi/getusers")
                .then().log().all().assertThat().statusCode(200).
                        body("error", equalTo(false)).extract().response().asString();
*/
        PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName("admin");
        auth.setPassword("admin123");


        RequestSpecification reqSpec = new RequestSpecBuilder()
                .setBaseUri("http://localhost:80/chat/lhc_web/index.php/site_admin")
                .setAuth(auth)
                .build();

        RequestSpecification request = given().log().all().spec(reqSpec);

        Response response = request.when().get("/restapi/getusers");


        ResponseSpecification respSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectBody("error", equalTo(false))
                .build();

        String myResponse = response.then().log().all().spec(respSpec).extract().asString();

        System.out.println(myResponse);

    }
}
