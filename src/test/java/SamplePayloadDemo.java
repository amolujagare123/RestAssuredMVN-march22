import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static PayLoad.SamplePayLoad.sampleResponse;

public class SamplePayloadDemo {

    @Test
    public void getPayload()
    {
        String response = sampleResponse();

       // System.out.println(response);

        JsonPath jsonPath = new JsonPath(response);

        int size =  jsonPath.getInt("courses.size()");
// 1. total number of courses
        System.out.println("size="+size);
//2.Print Purchase Amount
        int purchaseAmount = jsonPath.getInt("dashboard.purchaseAmount");

        System.out.println("purchaseAmount="+purchaseAmount);
// 3. Print Title of the first course
        String firstTitle = jsonPath.getString("courses[0].title");

        System.out.println("firstTitle="+firstTitle);
     //4. Print All course titles and their respective Prices
        for (int i=0;i<size;i++)
        {
            System.out.println(jsonPath.getString("courses["+i+"].title"));
        }

        // 5. Print no of copies sold by RPA Course


        for (int i=0;i<size;i++)
        {
            if(jsonPath.getString("courses["+i+"].title")=="RPA")
            {
                System.out.println(jsonPath.getInt("courses["+i+"].copies"));
            }
        }

    }
}
