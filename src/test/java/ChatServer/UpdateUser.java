package ChatServer;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UpdateUser {

    public static void main(String[] args) {

        RestAssured.baseURI="http://localhost:80/chat/lhc_web/index.php/site_admin";

        int userId = 90;
        String respUpdateUser = given().log().all().
                auth().preemptive().basic("admin", "admin123")
                .body("{\n" +
                        "  \"username\": \"vasu111\",\n" +
                        "  \"password\": \"r1234\",\n" +
                        "  \"email\": \"rahul@example.org\",\n" +
                        "  \"name\": \"rahul\",\n" +
                        "  \"surname\": \"P\",\n" +
                        "  \"chat_nickname\": \"rahul123\",\n" +
                        "  \"departments\": [\n" +
                        "    1,\n" +
                        "    2\n" +
                        "  ],\n" +
                        "  \"departments_read\": [\n" +
                        "    2\n" +
                        "  ],\n" +
                        "  \"department_groups\": [\n" +
                        "    1\n" +
                        "  ],\n" +
                        "  \"user_groups\": [\n" +
                        "    1\n" +
                        "  ]\n" +
                        "}")
                .when().put("/restapi/user/"+userId)
                .then().log().all().assertThat().statusCode(200).extract().asString();

        System.out.println(respUpdateUser);


    }
}
