package SampleRequest;

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

public class SampleCreateUserDataProvider2 {

    @Test (dataProvider = "getData")
    public void createUser(String name,String job) {

        RestAssured.baseURI= "https://reqres.in";


        given().log().all().header("Content-Type","application/json")
                .body(createUserPayLoad(name,job))

                .when().post("/api/users")
                .then().log().all().statusCode(201);

    }

    @DataProvider
    public Object[][] getData() throws IOException {

        FileInputStream fis = new FileInputStream("Data/myData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int rowCount= sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount-1][2]; // rowCount = 6

        for(int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1);

            XSSFCell name = row.getCell(0);
            if(name==null)
                data[i][0] ="";
            else
                data[i][0] = name.toString().trim();

            XSSFCell job = row.getCell(1);
            if(job==null)
                data[i][1] ="";
            else
                data[i][1] = job.toString().trim();
        }

       /* data[0][0] = "amol";
        data[0][1] = "Tester";

        data[1][0] = "rahul";
        data[1][1] = "lead";

        data[2][0] = "vasu";
        data[2][1] = "manager";

        data[3][0] = "priyanka";
        data[3][1] = "HR";
*/

        return  data;
    }



}
