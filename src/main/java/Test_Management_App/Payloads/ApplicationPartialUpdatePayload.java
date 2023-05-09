package Test_Management_App.Payloads;

public class ApplicationPartialUpdatePayload {

    private String app_name;
    private String technology_description;
    private String functionality_description;

    public ApplicationPartialUpdatePayload() {
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
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
