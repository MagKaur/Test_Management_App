package Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BINARIES", schema = "mango")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Binary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_binary")
    private int idBinary;
    @Column(name = "binary_description")
    @NotNull(message = "Binary description must not be null")
    @NotBlank(message = "Binary Description must not be empty")
    private String binaryDescription;
    @Column(name = "binary_link")
    @NotNull(message = "Binary Link must not be null")
    @NotBlank(message = "Binary Link must not be empty")
    private String binaryLink;

    @ManyToOne
    @JoinColumn(name = "id_project", nullable = false)
    @Column(name = "id_project")
    @JsonManagedReference
    @NotNull (message = "Project indication must not be null")
    private Project fkIdProjectBinary;
    @ManyToOne
    @JoinColumn(name = "id_application")
    @Column(name = "id_application")
    @JsonManagedReference
    private Application fkIdApplicationBinary;
    @ManyToOne
    @JoinColumn(name = "id_device")
    @Column(name = "id_device")
    @JsonManagedReference
    private DeviceModel fkIdDeviceModelBinary;
    @Column(name = "accepted_status")
    private boolean acceptedStatus;

    @Column(name = "BINARY_STATUS_TYPE")
    @NotNull
    @NotBlank (message = "Binary Status must not be empty")
    @Enumerated(EnumType.ORDINAL)
    private BinaryStatusType binaryStatus;

    protected Binary(){};

    Binary(int idBinary, String binaryDescription, String binaryLink, Project fkIdProjectBinary, Application fkIdApplicationBinary,
                DeviceModel fkIdDeviceModelBinary, BinaryStatusType binaryStatus){
        this.idBinary = idBinary;
        this.binaryDescription = binaryDescription;
        this.binaryLink = binaryLink;
        this.fkIdProjectBinary = fkIdProjectBinary;
        this.fkIdApplicationBinary = fkIdApplicationBinary;
        this.fkIdDeviceModelBinary = fkIdDeviceModelBinary;
        this.binaryStatus = binaryStatus;
    }

    Binary(int idBinary, String binaryDescription, String binaryLink, Project fkIdProjectBinary, Application fkIdApplicationBinary,
           DeviceModel fkIdDeviceModelBinary, boolean acceptedStatus, BinaryStatusType binaryStatus){
        this.idBinary = idBinary;
        this.binaryDescription = binaryDescription;
        this.binaryLink = binaryLink;
        this.fkIdProjectBinary = fkIdProjectBinary;
        this.fkIdApplicationBinary = fkIdApplicationBinary;
        this.fkIdDeviceModelBinary = fkIdDeviceModelBinary;
        this.acceptedStatus = acceptedStatus;
        this.binaryStatus = binaryStatus;
    }

    public int getIdBinary(){
        return idBinary;
    }

    public void setIdBinary(int idBinary){
        this.idBinary = idBinary;
    }

    public String getBinaryDescription(){
        return binaryDescription;
    }
    public void setBinaryDescription(String binaryDescription){
        this.binaryDescription = binaryDescription;
    }
    public String getBinaryLink(){
        return binaryLink;
    }
    public void setBinaryLink(String binaryLink){
        this.binaryLink = binaryLink;
    }

    public Project getFkIdProjectBinary(){
        return fkIdProjectBinary;
    }
    public void setFkIdProjectBinary(Project fkIdProjectBinary){
        this.fkIdProjectBinary = fkIdProjectBinary;
    }
    public Application getFkIdApplicationBinary(){
        return fkIdApplicationBinary;
    }
    public void setFkIdApplicationBinary(Application fkIdApplicationBinary){
        this.fkIdApplicationBinary = fkIdApplicationBinary;
    }

    public DeviceModel getFkIdDeviceModelBinary(){
        return fkIdDeviceModelBinary;
    }
    public void setFkIdDeviceModelBinary(DeviceModel fkIdDeviceModelBinary){
        this.fkIdDeviceModelBinary = fkIdDeviceModelBinary;
    }

    public boolean getAcceptedStatus(){
        return acceptedStatus;
    }

    public void setAcceptedStatus(boolean acceptedStatus) {
        this.acceptedStatus = acceptedStatus;
    }

    public BinaryStatusType getBinaryStatus(){
        return binaryStatus;
    }

    public void setBinaryStatus(BinaryStatusType binaryStatus) {
        this.binaryStatus = binaryStatus;
    }
}
