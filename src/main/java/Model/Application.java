package Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;


@Entity
@Table(name = "applications", schema = "mango")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Application implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_application")
    private int id_application;
    @Column(name = "app_name")
    @NotNull(message = "App Name must not be null")
    @NotBlank(message = "App Name must not be empty")
    private String app_name;
    @Column(name = "technology_description")
    @NotNull(message = "Technology description must not be null")
    @NotBlank(message = "Technology description must not be empty")
    private String technology_description;
    @Column(name = "functionality_description")
    @NotNull(message = "Functionality description must not be null")
    @NotBlank(message = "Functionality description must not be empty")
    private String functionality_description;

    @OneToMany(mappedBy = "fk_id_applicationNewAppModule", cascade = CascadeType.ALL)
    @JsonBackReference
    private ArrayList<NewAppModule> newAppModules = new ArrayList<>();

    @OneToMany(mappedBy = "fk_id_applicationProjectDetails", cascade = CascadeType.ALL)
    @JsonBackReference
    private ArrayList<ProjectDetails> projectDetails = new ArrayList<>();

    @OneToMany(mappedBy = "fk_id_applicationBinary", cascade = CascadeType.ALL)
    @JsonBackReference
    private ArrayList<Binary> binaries = new ArrayList<>();
//TODO dodawanie,usuwanie elementów z listy (dla wszystkich class) w oddzielnej klasie service
    // TODO dodać kolumne ze timestamp + dodać annotacje @CreationTimestamp ??? Zastanowic się czy będę potrzebowac np do obliczania deadline test tasku?
    protected Application (){}

    Application (int id_application, String app_name, String technology_description, String functionality_description){
        this.id_application = id_application;
        this.app_name = app_name;
        this.technology_description = technology_description;
        this.functionality_description = functionality_description;
    }

    Application (int id_application, String app_name, String technology_description, String functionality_description,
                 ArrayList<NewAppModule> newAppModules){
        this.id_application = id_application;
        this.app_name = app_name;
        this.technology_description = technology_description;
        this.functionality_description = functionality_description;
        this.newAppModules = newAppModules;
    }
    Application (int id_application, String app_name, String technology_description, String functionality_description,
                 ArrayList<NewAppModule> newAppModules,ArrayList<Binary> binaries){
        this.id_application = id_application;
        this.app_name = app_name;
        this.technology_description = technology_description;
        this.functionality_description = functionality_description;
        this.newAppModules = newAppModules;
        this.binaries = binaries;
    }
    Application (int id_application, String app_name, String technology_description, String functionality_description,
                 ArrayList<NewAppModule> newAppModules,ArrayList<Binary> binaries, ArrayList<ProjectDetails> projectDetails){
        this.id_application = id_application;
        this.app_name = app_name;
        this.technology_description = technology_description;
        this.functionality_description = functionality_description;
        this.newAppModules = newAppModules;
        this.binaries = binaries;
        this.projectDetails = projectDetails;
    }


    public int getId_application(){
        return id_application;
    }
    public void setId_application(int id_application){
        this.id_application = id_application;
    }

    public String getApp_name(){
        return app_name;
    }
    public void setApp_name(String app_name){
        this.app_name = app_name;
    }

    public String getTechnology_description(){
        return technology_description;
    }
    public void setTechnology_description(String technology_description){
        this. technology_description = technology_description;
    }

    public String getFunctionality_description() {
        return functionality_description;
    }
    public void setFunctionality_description(String functionality_description){
        this.functionality_description = functionality_description;
    }

    public ArrayList<NewAppModule> getNewAppModules() {
        return newAppModules;
    }
    public void setNewAppModules (ArrayList<NewAppModule> newAppModules){
        this.newAppModules = newAppModules;
    }

    public ArrayList<ProjectDetails> getProjectDetails(){
        return projectDetails;
    }

    public void setProjectDetails (ArrayList<ProjectDetails> projectDetails){
        this.projectDetails = projectDetails;
    }

    public ArrayList<Binary> getBinaries(){
       return binaries;
    }

    public void setBinaries(ArrayList<Binary> binaries) {
        this.binaries = binaries;
    }
}
