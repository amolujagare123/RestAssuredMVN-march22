package POJO;

import java.util.ArrayList;

public class AddJobPojo {

    String jobDescription;
    int jobId;
    String jobTitle;
    ArrayList<String> experience;
    ArrayList<Object> Project;

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public ArrayList<String> getExperience() {
        return experience;
    }

    public void setExperience(ArrayList<String> experience) {
        this.experience = experience;
    }

    public ArrayList<Object> getProject() {
        return Project;
    }

    public void setProject(ArrayList<Object> project) {
        Project = project;
    }


}
