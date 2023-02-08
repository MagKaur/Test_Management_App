package Model;

import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects", schema = "mango")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_project")
    private int idProject;
    @Column(name = "project_description")
    @NotNull(message = "Project Description must not be null")
    @NotBlank(message = "Project Description must not be empty")
    private String projectDescription;
    @Column(name = "project_name")
    @NotNull(message = "Project Name must not be null")
    @NotBlank(message = "Project Name must not be empty")
    private String projectName;

    @Column(name = "PROJECT_STATUS_TYPE")
    @NotNull(message = "Project Status must not be null")
    @NotBlank(message = "Project Status must not be empty")
    @Enumerated(EnumType.ORDINAL)
    private ProjectStatusType projectStatus;

    @OneToMany(mappedBy = "fkIdProjectProjectDetails", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ProjectDetails> projectDetails = new ArrayList<>();
    @OneToMany(mappedBy = "fkIdProjectBinary", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Binary> binaries = new ArrayList<>();



    protected Project() {
    }

    Project (int idProject,String projectDescription, String projectName, ProjectStatusType projectStatus){
        this.idProject = idProject;
        this.projectDescription = projectDescription;
        this.projectName = projectName;
        this.projectStatus = projectStatus;
    }

    Project (int idProject,String projectDescription, String projectName, ArrayList<ProjectDetails> projectDetails,
             ArrayList<Binary> binaries, ProjectStatusType projectStatus){
        this.idProject = idProject;
        this.projectDescription = projectDescription;
        this.projectName = projectName;
        this.projectDetails = projectDetails;
        this.binaries = binaries;
        this.projectStatus = projectStatus;
    }



    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }



    public List<ProjectDetails> getProjectDetails(){
        return projectDetails;
    }

    public void setProjectDetails(ArrayList<ProjectDetails> projectDetails){
        this.projectDetails = projectDetails;
    }
//TODO czy przy zmianie Array Lst na List tutaj tez zmieniac
    public List<Binary> getBinaries(){
        return binaries;
    }

    public void setBinaries(ArrayList<Binary> binaries) {
        this.binaries = binaries;
    }

    public ProjectStatusType getProjectStatus(){
        return projectStatus;
    }

    public void setProjectStatus(ProjectStatusType projectStatus){
        this.projectStatus = projectStatus;
    }
}
