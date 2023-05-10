package Test_Management_App.Model;

import javax.persistence.*;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_application;
    @Column(name = "app_name")
    private String appName;
    @Column(name = "technology_description")
    private String technology_description;
    @Column(name = "functionality_description")
    private String functionality_description;

    public Application() {
    }

    public int getId_application() {
        return id_application;
    }

    public void setId_application(int id_application) {
        this.id_application = id_application;
    }

    public String getApp_name() {
        return appName;
    }

    public void setApp_name(String app_name) {
        this.appName = appName;
    }

    public String getTechnology_description() {
        return technology_description;
    }

    public void setTechnology_description(String technology_description) {
        this.technology_description = technology_description;
    }

    public String getFunctionality_description() {
        return functionality_description;
    }

    public void setFunctionality_description(String functionality_description) {
        this.functionality_description = functionality_description;
    }
}
