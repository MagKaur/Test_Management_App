package Model;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "project_details", schema = "mango")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ProjectDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_project_details")
    private int idProjectDetails;

    @ManyToOne
    @JoinColumn(name = "id_project")
    @Column(name = "id_project")
    @JsonManagedReference
    @NotNull(message = "Project indication must not be null")
    private Project fkIdProjectProjectDetails;
    @ManyToOne
    @JoinColumn(name = "id_application")
    @Column(name = "id_application")
    @JsonManagedReference
    private Application fkIdApplicationProjectDetails;
    @ManyToOne
    @JoinColumn(name = "id_device")
    @Column(name = "id_device")
    @JsonManagedReference
    private DeviceModel fkIdDeviceModelProjectDetails;

    @Column(name = "accepted_status_device")
    private char acceptedStatusDevice;


    protected ProjectDetails(){};

    ProjectDetails(int idProjectDetails, Project fkIdProjectProjectDetails, Application fkIdApplicationProjectDetails) {
        this.idProjectDetails = idProjectDetails;
        this.fkIdProjectProjectDetails = fkIdProjectProjectDetails;
        this.fkIdApplicationProjectDetails = fkIdApplicationProjectDetails;

    }

    ProjectDetails(int idProjectDetails, Project fkIdProjectProjectDetails, DeviceModel fkIdDeviceModelProjectDetails) {
        this.idProjectDetails = idProjectDetails;
        this.fkIdProjectProjectDetails = fkIdProjectProjectDetails;
        this.fkIdDeviceModelProjectDetails = fkIdDeviceModelProjectDetails;
    }

    ProjectDetails(int idProjectDetails, Project fkIdProjectProjectDetails,
                   DeviceModel fkIdDeviceModelProjectDetails, char acceptedStatusDevice){
        this.idProjectDetails = idProjectDetails;
        this.fkIdProjectProjectDetails = fkIdProjectProjectDetails;
        this.fkIdDeviceModelProjectDetails = fkIdDeviceModelProjectDetails;
        this.acceptedStatusDevice = acceptedStatusDevice;
    }


    public int getIdProjectDetails() {
        return idProjectDetails;
    }

    public void setIdProjectDetails(int idProjectDetails) {
        this.idProjectDetails = idProjectDetails;
    }

    public Project getFkIdProjectProjectDetails(){
        return fkIdProjectProjectDetails;
    }
    public void setFkIdProjectProjectDetails(Project fkIdProjectProjectDetails){
        this.fkIdProjectProjectDetails = fkIdProjectProjectDetails;
    }

    public Application getFkIdApplicationProjectDetails(){
        return fkIdApplicationProjectDetails;
    }
    public void setFkIdApplicationProjectDetails(Application fkIdApplicationProjectDetails){
        this.fkIdApplicationProjectDetails = fkIdApplicationProjectDetails;
    }

    public DeviceModel getFkIdDeviceModelProjectDetails(){
        return fkIdDeviceModelProjectDetails;
    }
    public void setFkIdDeviceModelProjectDetails(DeviceModel fkIdDeviceModelProjectDetails){
        this.fkIdDeviceModelProjectDetails = fkIdDeviceModelProjectDetails;
    }

    public char getAcceptedStatusDevice() {
        return acceptedStatusDevice;
    }

    public void setAcceptedStatusDevice(char acceptedStatusDevice) {
        this.acceptedStatusDevice = acceptedStatusDevice;
    }
}
