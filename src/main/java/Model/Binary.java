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
    @Column(name = "binary_name")
    @NotNull(message = "BinaryService Name must not be null")
    @NotBlank(message = "BinaryService Name must not be empty")
    private String binaryName;
    @Column(name = "binary_description")
    @NotNull(message = "BinaryService Description must not be null")
    @NotBlank(message = "BinaryService Description must not be empty")
    private String binaryDescription;
    @Column(name = "binary_link")
    @NotNull(message = "BinaryService Link must not be null")
    @NotBlank(message = "BinaryService Link must not be empty")
    private String binaryLink;

    @ManyToOne
    @JoinColumn(name = "id_project", nullable = false)
    @JsonManagedReference
    @NotNull (message = "Project indication must not be null")
    private Project fkIdProjectBinary;
    @ManyToOne
    @JoinColumn(name = "id_application")
    @JsonManagedReference
    private Application fkIdApplicationBinary;

    @ManyToOne
    @JoinColumn(name = "ID_APP_MODULE")
    @JsonManagedReference
    private NewAppModule fkIdNewAppModuleBinary;

    @ManyToOne
    @JoinColumn(name = "id_device")
    @JsonManagedReference
    private DeviceModel fkIdDeviceModelBinary;

    @Column(name = "binary_status_type")
    @NotNull(message = "BinaryService Status must not be null" )
    @NotBlank (message = "BinaryService Status must not be empty")
    @Enumerated(EnumType.ORDINAL)
    private BinaryStatusType binaryStatus;

    public Binary(){};

    Binary(String binaryName, String binaryDescription, String binaryLink, Project fkIdProjectBinary,
                Application fkIdApplicationBinary, BinaryStatusType binaryStatus){
        this.binaryName = binaryName;
        this.binaryDescription = binaryDescription;
        this.binaryLink = binaryLink;
        this.fkIdProjectBinary = fkIdProjectBinary;
        this.fkIdApplicationBinary = fkIdApplicationBinary;
        this.binaryStatus = binaryStatus;
    }

    Binary(String binaryName, String binaryDescription, String binaryLink, Project fkIdProjectBinary,
           DeviceModel fkIdDeviceModelBinary, BinaryStatusType binaryStatus){
        this.binaryName = binaryName;
        this.binaryDescription = binaryDescription;
        this.binaryLink = binaryLink;
        this.fkIdProjectBinary = fkIdProjectBinary;
        this.fkIdDeviceModelBinary = fkIdDeviceModelBinary;
        this.binaryStatus = binaryStatus;
    }

    Binary(String binaryName, String binaryDescription, String binaryLink, NewAppModule fkIdNewAppModuleBinary,  BinaryStatusType binaryStatus){
        this.binaryName = binaryName;
        this.binaryDescription = binaryDescription;
        this.binaryLink = binaryLink;
        this.fkIdNewAppModuleBinary = fkIdNewAppModuleBinary;
        this.binaryStatus = binaryStatus;
    }

    public int getIdBinary(){
        return idBinary;
    }

    public void setIdBinary(int idBinary){
        this.idBinary = idBinary;
    }

    public String getBinaryName(){
        return binaryName;
    }
    public void setBinaryName(String binaryName){
        this.binaryName = binaryName;
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

    public void setFkIdNewAppModuleBinary(NewAppModule fkIdNewAppModuleBinary){
        this.fkIdNewAppModuleBinary = fkIdNewAppModuleBinary;
    }

    public NewAppModule getFkIdNewAppModuleBinary() {
        return fkIdNewAppModuleBinary;
    }

    public DeviceModel getFkIdDeviceModelBinary(){
        return fkIdDeviceModelBinary;
    }
    public void setFkIdDeviceModelBinary(DeviceModel fkIdDeviceModelBinary){
        this.fkIdDeviceModelBinary = fkIdDeviceModelBinary;
    }

    public BinaryStatusType getBinaryStatus(){
        return binaryStatus;
    }

    public void setBinaryStatus(BinaryStatusType binaryStatus) {
        this.binaryStatus = binaryStatus;
    }
}
