package Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "applications", schema = "mango")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Application implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_application")
    private int idApplication;
    @Column(name = "app_name")
    @NotNull(message = "App Name must not be null")
    @NotBlank(message = "App Name must not be empty")
    private String appName;
    @Column(name = "technology_description")
    @NotNull(message = "Technology description must not be null")
    @NotBlank(message = "Technology description must not be empty")
    private String technologyDescription;
    @Column(name = "functionality_description")
    @NotNull(message = "Functionality description must not be null")
    @NotBlank(message = "Functionality description must not be empty")
    private String functionalityDescription;

    @OneToMany(mappedBy = "fkIdApplicationNewAppModule", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<NewAppModule> newAppModules = new ArrayList<>();

    @OneToMany(mappedBy = "fkIdApplicationProjectDetails", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ProjectDetails> projectDetails = new ArrayList<>();
//TODO tu musiałam zmienić na List, czy w konstruktorach też zmieniać na list?
    @OneToMany(mappedBy = "fkIdApplicationBinary", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Binary> binaries = new ArrayList<>();
//TODO dodawanie (dla wszystkich class) w oddzielnej klasie service
    // TODO dodać kolumne ze timestamp + dodać annotacje @CreationTimestamp ??? Zastanowic się czy będę potrzebowac np do obliczania deadline test tasku?
    protected Application (){}
    Application (int idApplication, String appName, String technologyDescription, String functionalityDescription){
        this.idApplication = idApplication;
        this.appName = appName;
        this.technologyDescription = technologyDescription;
        this.functionalityDescription = functionalityDescription;
    }

    Application (int idApplication, String appName, String technologyDescription, String functionalityDescription,
                 ArrayList<NewAppModule> newAppModules){
        this.idApplication = idApplication;
        this.appName = appName;
        this.technologyDescription = technologyDescription;
        this.functionalityDescription = functionalityDescription;
        this.newAppModules = newAppModules;
    }
    Application (int idApplication, String appName, String technologyDescription, String functionalityDescription,
                 ArrayList<NewAppModule> newAppModules, ArrayList<Binary> binaries){
        this.idApplication = idApplication;
        this.appName = appName;
        this.technologyDescription = technologyDescription;
        this.functionalityDescription = functionalityDescription;
        this.newAppModules = newAppModules;
        this.binaries = binaries;
    }
    Application (int idApplication, String appName, String technologyDescription, String functionalityDescription,
                 ArrayList<NewAppModule> newAppModules,ArrayList<Binary> binaries, ArrayList<ProjectDetails> projectDetails){
        this.idApplication = idApplication;
        this.appName = appName;
        this.technologyDescription = technologyDescription;
        this.functionalityDescription = functionalityDescription;
        this.newAppModules = newAppModules;
        this.binaries = binaries;
        this.projectDetails = projectDetails;
    }


    public int getIdApplication(){
        return idApplication;
    }
    public void setIdApplication(int idApplication){
        this.idApplication = idApplication;
    }

    public String getAppName(){
        return appName;
    }
    public void setAppName(String appName){
        this.appName = appName;
    }

    public String getTechnologyDescription(){
        return technologyDescription;
    }
    public void setTechnologyDescription(String technologyDescription){
        this. technologyDescription = technologyDescription;
    }

    public String getFunctionalityDescription() {
        return functionalityDescription;
    }
    public void setFunctionalityDescription(String functionalityDescription){
        this.functionalityDescription = functionalityDescription;
    }

    public List<NewAppModule> getNewAppModules() {
        return newAppModules;
    }
    public void setNewAppModules (List<NewAppModule> newAppModules){
        this.newAppModules = newAppModules;
    }

    public List<ProjectDetails> getProjectDetails(){
        return projectDetails;
    }

    public void setProjectDetails (List<ProjectDetails> projectDetails){
        this.projectDetails = projectDetails;
    }

    public List<Binary> getBinaries(){
       return binaries;
    }

    public void setBinaries(List<Binary> binaries) {
        this.binaries = binaries;
    }
}
