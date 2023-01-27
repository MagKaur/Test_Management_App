package Model;

public class Project {


    private int id_project;
    private String project_description;
    private String project_name;


    Project (int id_project,String project_description, String project_name){
        this.id_project = id_project;
        this.project_description = project_description;
        this.project_name = project_name;
    }

    public Project() {
    }


    public int getId_project() {
        return id_project;
    }

    public void setId_project(int id_project) {
        this.id_project = id_project;
    }

    public String getProject_description() {
        return project_description;
    }

    public void setProject_description(String project_description) {
        this.project_description = project_description;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }


}
