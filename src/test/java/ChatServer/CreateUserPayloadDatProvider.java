package ChatServer;

import io.restassured.RestAssured;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static PayLoad.ChatServerPayload.createChatUser;
import static io.restassured.RestAssured.given;

public class CreateUserPayloadDatProvider {

    @Test (dataProvider = "getData")
    public void createUserTest(String username,String password,
                               String email,String name,String surname,String nickName) {

        RestAssured.baseURI="http://localhost:80/chat/lhc_web/index.php/site_admin";


        String respCreateUser = given().log().all().
                auth().preemptive().basic("admin", "admin123")
                .body(createChatUser(username,password,email,name,surname,nickName))
                .when().post("/restapi/user")
                .then().log().all().assertThat()./*statusCode(200).*/extract().asString();

        System.out.println(respCreateUser);


    }

    @DataProvider
    public Object[][] getData() throws IOException {

        FileInputStream fis = new FileInputStream("Data/myData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("chat user");

        int rowCount= sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount-1][colCount]; // rowCount = 6

        for(int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1);

            for(int j=0;j<colCount;j++) {
                XSSFCell cell = row.getCell(j);
                if (cell == null)
                    data[i][j] = "";
                else
                    data[i][j] = cell.toString().trim();
            }
        }

        return  data;
    }

}
