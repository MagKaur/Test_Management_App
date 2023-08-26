package Test_Management_App.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "binary")
public class Binary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBinary;
    @Column(name = "binary_name")
    private String binaryName;
    @Column(name = "binary_description")
    private String binaryDescription;
    @Column(name = "binary_link")
    private String binaryLink;

    @ManyToOne
    @JoinColumn(name = "id_application")
    @JsonIgnore
    private Application idApplication;

    @ManyToOne
    @JoinColumn(name = "id_device")
    @JsonIgnore
    private DeviceModel idDevice;

    @Enumerated(EnumType.STRING)
    @Column(name = "binary_status_type")
    private BinaryStatusType binaryStatusType;

    public Binary(){}

    public int getIdBinary() {
        return idBinary;
    }

    public void setIdBinary(int idBinary) {
        this.idBinary = idBinary;
    }

    public String getBinaryName() {
        return binaryName;
    }

    public void setBinaryName(String binaryName) {
        this.binaryName = binaryName;
    }

    public String getBinaryDescription() {
        return binaryDescription;
    }

    public void setBinaryDescription(String binaryDescription) {
        this.binaryDescription = binaryDescription;
    }

    public String getBinaryLink() {
        return binaryLink;
    }

    public void setBinaryLink(String binaryLink) {
        this.binaryLink = binaryLink;
    }

    public Application getIdApplication() {
        return idApplication;
    }

    public void setIdApplication(Application idApplication) {
        this.idApplication = idApplication;
    }

    public DeviceModel getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(DeviceModel idDevice) {
        this.idDevice = idDevice;
    }

    public BinaryStatusType getBinaryStatusType() {
        return binaryStatusType;
    }

    public void setBinaryStatusType(BinaryStatusType binaryStatusType) {
        this.binaryStatusType = binaryStatusType;
    }
}
