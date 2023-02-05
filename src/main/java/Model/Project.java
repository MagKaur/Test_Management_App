package Model;

import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "projects", schema = "mango")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Project implements Serializable { //TODO implements serializable?
    //TODO jak wykorzystać stworzone enumy?

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_project")
    private int id_project;
    @Column(name = "project_description")
    @NotBlank(message = "Project Description must not be empty")
    private String project_description;
    @Column(name = "project_name")
    @NotBlank(message = "Project Name must not be empty")
    private String project_name;

    @Column(name = "project_status")
    @NotBlank(message = "Project_status must not be empty")
    private String project_status;

    @OneToMany(mappedBy = "fk_id_projectProjectDetails", cascade = CascadeType.ALL)
    @JsonBackReference
    private ArrayList<ProjectDetails> projectDetails = new ArrayList<>();
    @OneToMany(mappedBy = "fk_id_projectBinary", cascade = CascadeType.ALL)
    @JsonBackReference
    private ArrayList<Binary> binaries = new ArrayList<>();



    protected Project() {
    }

    Project (int id_project,String project_description, String project_name, String project_status){
        this.id_project = id_project;
        this.project_description = project_description;
        this.project_name = project_name;
        this.project_status = project_status;
    }

    Project (int id_project,String project_description, String project_name, ArrayList<ProjectDetails> projectDetails,
             ArrayList<Binary> binaries, String project_status){
        this.id_project = id_project;
        this.project_description = project_description;
        this.project_name = project_name;
        this.projectDetails = projectDetails;
        this.binaries = binaries;
        this.project_status = project_status;
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

    public String getProject_status(){
        return project_status = project_status;
    }

    public void setProject_status(){
        this.project_status = project_status;
    }
}
