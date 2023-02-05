package Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;

@Entity
@Table(name = "BINARIES", schema = "mango")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Binary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_binary")
    @NotNull
    private int id_binary;
    @Column(name = "binary_description")
    @NotBlank(message = "Binary Description must not be empty")
    private String binary_description;
    @Column(name = "binary_link")
    @NotBlank(message = "Binary Link must not be empty")
    private String binary_link;

    @ManyToOne
    @JoinColumn(name = "id_project", nullable = false)
    @Column(name = "id_project")
    @JsonManagedReference
    @NotNull //TODO a czy tutaj adnotacje NOT NULL tez?
    private Project fk_id_projectBinary;
    @ManyToOne
    @JoinColumn(name = "id_application")
    @Column(name = "id_application")
    @JsonManagedReference
    @NotNull
    private Application fk_id_applicationBinary;
    @ManyToOne
    @JoinColumn(name = "id_device")
    @Column(name = "id_device")
    @JsonManagedReference
    @NotNull
    private DeviceModel fk_id_deviceModelBinary;
    @Column(name = "accepted_status")
    private boolean accepted_status;

    @Column(name = "binary_status")
    @NotBlank (message = "Binary Status must not be empty")
    private String binary_status;

    protected Binary(){};

    Binary(int id_binary, String binary_description, String binary_link, Project fk_id_projectBinary, Application fk_id_applicationBinary,
                DeviceModel fk_id_deviceModelBinary, String binary_status){
        this.id_binary = id_binary;
        this.binary_description = binary_description;
        this.binary_link = binary_link;
        this.fk_id_projectBinary = fk_id_projectBinary;
        this.fk_id_applicationBinary = fk_id_applicationBinary;
        this.fk_id_deviceModelBinary = fk_id_deviceModelBinary;
        this.binary_status = binary_status;
    }

    Binary(int id_binary, String binary_description, String binary_link, Project fk_id_projectBinary, Application fk_id_applicationBinary,
           DeviceModel fk_id_deviceModelBinary, boolean accepted_status, String binary_status){
        this.id_binary = id_binary;
        this.binary_description = binary_description;
        this.binary_link = binary_link;
        this.fk_id_projectBinary = fk_id_projectBinary;
        this.fk_id_applicationBinary = fk_id_applicationBinary;
        this.fk_id_deviceModelBinary = fk_id_deviceModelBinary;
        this.accepted_status = accepted_status;
        this.binary_status = binary_status;
    }

    public int getId_binary(){
        return id_binary;
    }

    public void setId_binary(int id_binary){
        this.id_binary = id_binary;
    }

    public String getBinary_description(){
        return binary_description;
    }
    public void setBinary_description(String binary_description){
        this.binary_description = binary_description;
    }
    public String getBinary_link(){
        return binary_link;
    }
    public void setBinary_link(String binary_link){
        this.binary_link = binary_link;
    }

    public Project getFk_id_projectBinary(){
        return fk_id_projectBinary;
    }
    public void setFk_id_projectBinary(Project fk_id_projectBinary){
        this.fk_id_projectBinary = fk_id_projectBinary;
    }
    public Application getFk_id_applicationBinary(){
        return fk_id_applicationBinary;
    }
    public void setFk_id_applicationBinary(Application fk_id_applicationBinary){
        this.fk_id_applicationBinary = fk_id_applicationBinary;
    }

    public DeviceModel getFk_id_deviceModelBinary(){
        return fk_id_deviceModelBinary;
    }
    public void setFk_id_deviceModelBinary(DeviceModel fk_id_deviceModelBinary){
        this.fk_id_deviceModelBinary = fk_id_deviceModelBinary;
    }

    public boolean getAccepted_status(){
        return accepted_status;
    }

    public void setAccepted_status(boolean accepted_status) {
        this.accepted_status = accepted_status;
    }

    public String getBinary_status(){
        return binary_status;
    }

    public void setBinary_status(String binary_status) {
        this.binary_status = binary_status;
    }
}
