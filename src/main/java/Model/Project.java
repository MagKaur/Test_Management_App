package Model;

import javax.persistence.*;

@Entity
@Table(name = "projects", schema = "mango")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_project")
    private int id_project;
    @Column(name = "project_description")
    private String project_description;
    @Column(name = "project_name")
    private String project_name;


    protected Project() {
    }

    Project (int id_project,String project_description, String project_name){
        this.id_project = id_project;
        this.project_description = project_description;
        this.project_name = project_name;
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
