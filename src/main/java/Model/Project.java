package Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "projects", schema = "mango")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_project")
    @NotNull
    private int id_project;
    @Column(name = "project_description")
    @NotNull
    private String project_description;
    @Column(name = "project_name")
    @NotNull
    private String project_name;

    @OneToMany(mappedBy = "fk_id_projectProjectDetails", cascade = CascadeType.ALL)
    @JsonBackReference
    private ArrayList<ProjectDetails> projectDetails = new ArrayList<>();
    @OneToMany(mappedBy = "fk_id_projectBinary", cascade = CascadeType.ALL)
    @JsonBackReference
    private ArrayList<Binary> binaries = new ArrayList<>();
    //TODO jackson annotations - I need them too + ignore obmyslic logike


    protected Project() {
    }

    Project (int id_project,String project_description, String project_name){
        this.id_project = id_project;
        this.project_description = project_description;
        this.project_name = project_name;
    }

    Project (int id_project,String project_description, String project_name, ArrayList<ProjectDetails> projectDetails,
             ArrayList<Binary> binaries){
        this.id_project = id_project;
        this.project_description = project_description;
        this.project_name = project_name;
        this.projectDetails = projectDetails;
        this.binaries = binaries;
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



    public ArrayList<ProjectDetails> getProjectDetails(){
        return projectDetails;
    }

    public void setProjectDetails(ArrayList<ProjectDetails> projectDetails){
        this.projectDetails = projectDetails;
    }

    public ArrayList<Binary> getBinaries(){
        return binaries = binaries;
    }

    public void setBinaries(ArrayList<Binary> binaries) {
        this.binaries = binaries;
    }
}
