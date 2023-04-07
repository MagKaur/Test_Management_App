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
    @JsonManagedReference
    @NotNull(message = "Project indication must not be null")
    private Project fkIdProjectProjectDetails;
    @ManyToOne
    @JoinColumn(name = "id_application")
    @JsonManagedReference
    private Application fkIdApplicationProjectDetails;
    @ManyToOne
    @JoinColumn(name = "id_device")
    @JsonManagedReference
    private DeviceModel fkIdDeviceModelProjectDetails;

    @Column(name = "accepted_status_type")
    @Enumerated(EnumType.ORDINAL)
    private AcceptedStatusType acceptedStatus;


    protected ProjectDetails(){};

    ProjectDetails(Project fkIdProjectProjectDetails, Application fkIdApplicationProjectDetails) {
        this.fkIdProjectProjectDetails = fkIdProjectProjectDetails;
        this.fkIdApplicationProjectDetails = fkIdApplicationProjectDetails;

    }

    ProjectDetails(Project fkIdProjectProjectDetails, DeviceModel fkIdDeviceModelProjectDetails) {
        this.fkIdProjectProjectDetails = fkIdProjectProjectDetails;
        this.fkIdDeviceModelProjectDetails = fkIdDeviceModelProjectDetails;
    }

    ProjectDetails(Project fkIdProjectProjectDetails,
                   DeviceModel fkIdDeviceModelProjectDetails, AcceptedStatusType acceptedStatus){
        this.fkIdProjectProjectDetails = fkIdProjectProjectDetails;
        this.fkIdDeviceModelProjectDetails = fkIdDeviceModelProjectDetails;
        this.acceptedStatus = acceptedStatus;
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

    public AcceptedStatusType getAcceptedStatusDevice() {
        return acceptedStatus;
    }

    public void setAcceptedStatusDevice(AcceptedStatusType acceptedStatusDevice) {
        this.acceptedStatus = acceptedStatus;
    }
}
