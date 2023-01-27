package Model;


public class ProjectDetails {
    private int id_project_details;

    private Project fk_id_projectProjectDetails;
    private Application fk_id_applicationProjectDetails;
    private DeviceModel fk_id_deviceModelProjectDetails;


    ProjectDetails(int id_project_details, Project fk_id_projectProjectDetails, Application fk_id_applicationProjectDetails) {
        this.id_project_details = id_project_details;
        this.fk_id_projectProjectDetails = fk_id_projectProjectDetails;
        this.fk_id_applicationProjectDetails = fk_id_applicationProjectDetails;

    }

    ProjectDetails(int id_project_details, Project fk_id_projectProjectDetails, DeviceModel fk_id_deviceModelProjectDetails) {
        this.id_project_details = id_project_details;
        this.fk_id_projectProjectDetails = fk_id_projectProjectDetails;
        this.fk_id_deviceModelProjectDetails = fk_id_deviceModelProjectDetails;
    }

    ProjectDetails(int id_project_details, Project fk_id_projectProjectDetails, Application fk_id_applicationProjectDetails,
                   DeviceModel fk_id_deviceModelProjectDetails){
        this.id_project_details = id_project_details;
        this.fk_id_projectProjectDetails = fk_id_projectProjectDetails;
        this.fk_id_applicationProjectDetails = fk_id_applicationProjectDetails;
        this.fk_id_deviceModelProjectDetails = fk_id_deviceModelProjectDetails;
    }


    public int getId_project_details() {
        return id_project_details;
    }

    public void setId_project_details(int id_project_details) {
        this.id_project_details = id_project_details;
    }

    public Project getFk_id_projectProjectDetails(){
        return fk_id_projectProjectDetails;
    }
    public void setFk_id_projectProjectDetails(Project fk_id_projectProjectDetails){
        this.fk_id_projectProjectDetails = fk_id_projectProjectDetails;
    }

    public Application getFk_id_applicationProjectDetails(){
        return fk_id_applicationProjectDetails;
    }
    public void setFk_id_applicationProjectDetails(Application fk_id_applicationProjectDetails){
        this.fk_id_applicationProjectDetails = fk_id_applicationProjectDetails;
    }

    public DeviceModel getFk_id_deviceModelProjectDetails(){
        return fk_id_deviceModelProjectDetails;
    }
    public void setFk_id_deviceModelProjectDetails(DeviceModel fk_id_deviceModelProjectDetails){
        this.fk_id_deviceModelProjectDetails = fk_id_deviceModelProjectDetails;
    }

}
