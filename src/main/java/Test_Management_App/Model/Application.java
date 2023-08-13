package Test_Management_App.Model;

import javax.persistence.*;

@Entity
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idApplication;
    @Column(name = "app_name")
    private String appName;
    @Column(name = "technology_description")
    private String technologyDescription;
    @Column(name = "functionality_description")
    private String functionalityDescription;

    public Application() {
    }

    public int getIdApplication() {
        return idApplication;
    }

    public void setIdApplication(int idApplication) {
        this.idApplication = idApplication;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getTechnologyDescription() {
        return technologyDescription;
    }

    public void setTechnologyDescription(String technologyDescription) {
        this.technologyDescription = technologyDescription;
    }

    public String getFunctionalityDescription() {
        return functionalityDescription;
    }

    public void setFunctionalityDescription(String functionalityDescription) {
        this.functionalityDescription = functionalityDescription;
    }
}
