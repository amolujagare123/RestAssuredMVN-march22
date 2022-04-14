package SampleRequest.UsingTestNG;

import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static PayLoad.SampleRequest.createUserPayLoad;
import static io.restassured.RestAssured.given;

public class CreateSampleUserPayload {

    @Test (dataProvider = "getData")
    public void createUserRequest(String name,String job)
    {
        RestAssured.baseURI= "https://reqres.in";

      //  String name = "Vivek";
      //  String job = "intern";
        given().log().all().header("Content-Type","application/json")
                .body(createUserPayLoad(name,job))
                .when().post("/api/users")
                .then().log().all().statusCode(201);
    }

    @DataProvider
    public Object[][] getData()                // Arrays (2 dimensional) method returning value
    {
        Object[][] data = new Object[5][2]; //(row x col)

        data[0][0] = "vivek";
        data[0][1] = "intern";

        data[1][0] = "vishal";
        data[1][1] = "tester";

        data[2][0] = "amit";
        data[2][1] = "manager";

        data[3][0] = "rahul";
        data[3][1] = "test lead";

        data[4][0] = "rajesh";
        data[4][1] = "HR";

        return data;
    }

}
