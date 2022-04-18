package SampleRequest;

import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static PayLoad.SampleRequest.createUserPayLoad;
import static io.restassured.RestAssured.given;

public class SampleCreateUserDataProvider {

    @Test (dataProvider = "getData")
    public void createUser(String name,String job) {

        RestAssured.baseURI= "https://reqres.in";


        given().log().all().header("Content-Type","application/json")
                .body(createUserPayLoad(name,job))

                .when().post("/api/users")
                .then().log().all().statusCode(201);

    }

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data = new Object[4][2];

        data[0][0] = "amol";
        data[0][1] = "Tester";

        data[1][0] = "rahul";
        data[1][1] = "lead";

        data[2][0] = "vasu";
        data[2][1] = "manager";

        data[3][0] = "priyanka";
        data[3][1] = "HR";


        return  data;
    }



}
