package SampleRequest.UsingTestNG;

import io.restassured.RestAssured;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static PayLoad.SampleRequest.createUserPayLoad;
import static io.restassured.RestAssured.given;

public class CreateSampleUserPayloadExcel {

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
    public Object[][] getData() throws IOException                // Arrays (2 dimensional) method returning value
    {
        FileInputStream fis = new FileInputStream("Data/myData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount][2]; //(row x col)

        for(int i=0;i<rowCount;i++)
        {
            XSSFRow row = sheet.getRow(i);

            XSSFCell name = row.getCell(0);

            if(name==null)
                data[i][0] = "";
            else {
                data[i][0] = name.toString().trim();
            }

            XSSFCell job = row.getCell(1);

            if(job==null)
                data[i][1]="";
            else
                data[i][1] = row.getCell(1).toString().trim();
        }

       /* data[0][0] = "vivek";
        data[0][1] = "intern";

        data[1][0] = "vishal";
        data[1][1] = "tester";

        data[2][0] = "amit";
        data[2][1] = "manager";

        data[3][0] = "rahul";
        data[3][1] = "test lead";

        data[4][0] = "rajesh";
        data[4][1] = "HR";*/

        return data;
    }

}
