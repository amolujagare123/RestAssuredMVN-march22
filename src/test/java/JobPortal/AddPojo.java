package JobPortal;

import POJO.AddJobPojo;
import POJO.Project;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class AddPojo {
    @Test
    public void addJob()
    {
        RestAssured.baseURI = "http://localhost:9897/";

        AddJobPojo ob = new AddJobPojo();
        ob.setJobDescription("Developer");
        ob.setJobId(1);
        ob.setJobDescription("PHP developer");

        ArrayList<String> experience = new ArrayList<String>() {{
            add("3 years in manual testing");
            add("1 year in selenium");
        }};
        ob.setExperience(experience);

        Project project = new Project();

        project.setProjectName("Job portal");
        ArrayList<String> technologies = new ArrayList<String>(){{
            add("PHP");
            add("MySql");
        }};

        project.setTechnology(technologies);

        ArrayList<Object> projectObject = new ArrayList<>();
        projectObject.add(project);

        ob.setProject(projectObject);

        given().log().all().header("Content-Type","application/json")
                .body(ob)
                .when().post("/normal/webapi/add")
                .then().log().all().assertThat().statusCode(201);
    }
}
