package Model;

import com.sun.istack.NotNull;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "applications", schema = "mango")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_application")
    @NotNull
    private int id_application;
    @Column(name = "app_name")
    @NotNull
    private String app_name;
    @Column(name = "technology_description")
    @NotNull
    private String technology_description;
    @Column(name = "functionality_description")
    @NotNull
    private String functionality_description;

    @OneToMany(mappedBy = "fk_id_applicationNewAppModule", cascade = CascadeType.ALL)
    //TODO Czy tu też NOT NULLE sie przydadzą?
    private ArrayList<NewAppModule> newAppModules = new ArrayList<>();

    @OneToMany(mappedBy = "fk_id_applicationProjectDetails", cascade = CascadeType.ALL)
    private ArrayList<ProjectDetails> projectDetails = new ArrayList<>();

    @OneToMany(mappedBy = "fk_id_applicationBinary", cascade = CascadeType.ALL)
    private ArrayList<Binary> binaries = new ArrayList<>();
//TODO dodawanie,usuwanie elementów z listy (dla wszystkich class) w oddzielnej klasie service
    //TODO dodać kolumne ze timestamp + dodać annotacje @CreationTimestamp
    protected Application (){}

    Application (int id_application, String app_name, String technology_description, String functionality_description){
        this.id_application = id_application;
        this.app_name = app_name;
        this.technology_description = technology_description;
        this.functionality_description = functionality_description;
    }


    //TODO konstruktory z listami
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
