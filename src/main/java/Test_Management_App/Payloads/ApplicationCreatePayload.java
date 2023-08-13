package Test_Management_App.Payloads;

public class ApplicationCreatePayload {

    private String appName;
    private String technologyDescription;
    private String functionalityDescription;

    public ApplicationCreatePayload() {
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
