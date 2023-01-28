package Model;

import javax.persistence.*;

@Entity
@Table(name = "applications", schema = "mango")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_application")
    private int id_application;
    @Column(name = "app_name")
    private String app_name;
    @Column(name = "technology_description")
    private String technology_description;
    @Column(name = "functionality_description")
    private String functionality_description;

    //do not let me go further without no args constructor.
    protected Application (){}

    Application (int id_application, String app_name, String technology_description, String functionality_description){
        this.id_application = id_application;
        this.app_name = app_name;
        this.technology_description = technology_description;
        this.functionality_description = functionality_description;
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
}
