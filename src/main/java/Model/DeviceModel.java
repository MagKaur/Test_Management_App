package Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "device_models", schema = "mango")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class DeviceModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_device")
    private int idDevice;
    @Column(name = "producer_name")
    @NotNull (message = "Producer name must not be null")
    @NotBlank(message = "Producer name must not be empty")
    private String producerName;
    @Column(name = "model_name")
    @NotNull(message = "Model name must not be null")
    @NotBlank(message = "Model name must not be empty")
    private String modelName;
    @Column(name = "premiere_quarter")
    @NotNull(message = "Premiere Quarter must not be null")
    @NotBlank(message = "Premiere Quarter must not be empty")
    private String premiereQuarter;
    @Column(name = "volte")
    @NotNull(message = "VoLTE indication must not be null")
    @NotBlank(message = "VoLTE indication must not be empty")
    @Enumerated(EnumType.ORDINAL)
    private DeviceModelFeaturesStatus volte;
    @Column(name = "vowifi")
    @NotNull(message = "VoWiFi indication must not be null")
    @NotBlank(message = "VoWiFi indication must not be empty")
    @Enumerated(EnumType.ORDINAL)
    private DeviceModelFeaturesStatus vowifi;
    @Column(name = "sa_nsa_5g")
    @NotNull(message = "sa_nsa_5G indication must not be null")
    @NotBlank(message = "sa_nsa_5G indication must not be empty")
    @Enumerated(EnumType.ORDINAL)
    private DeviceModelFeaturesStatus saNsa5g;
    @Column(name = "e_sim")
    @NotNull(message = "e-sim indication must not be null")
    @NotBlank(message = "e-sim indication must not be empty")
    @Enumerated(EnumType.ORDINAL)
    private DeviceModelFeaturesStatus eSim;
    @Column(name = "rcs")
    @NotNull(message = "rcs indication must not be null")
    @NotBlank(message = "rcs indication must not be empty")
    @Enumerated(EnumType.ORDINAL)
    private DeviceModelFeaturesStatus rcs;

    @OneToMany(mappedBy = "fkIdDeviceModelProjectDetails", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ProjectDetails> projectDetails = new ArrayList<>();
    @OneToMany(mappedBy = "fkIdDeviceModelBinary", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Binary> binaries = new ArrayList<>();



    public DeviceModel(){};

    DeviceModel (String producerName, String modelName, String premiereQuarter, DeviceModelFeaturesStatus volte,
                 DeviceModelFeaturesStatus vowifi, DeviceModelFeaturesStatus saNsa5g, DeviceModelFeaturesStatus eSim, DeviceModelFeaturesStatus rcs){
        this.producerName = producerName;
        this.modelName = modelName;
        this.premiereQuarter = premiereQuarter;
        this.volte = volte;
        this.vowifi = vowifi;
        this.saNsa5g = saNsa5g;
        this.eSim = eSim;
        this.rcs = rcs;
    }

    DeviceModel (String producerName, String modelName, String premiereQuarter, DeviceModelFeaturesStatus volte,
                 DeviceModelFeaturesStatus vowifi, DeviceModelFeaturesStatus saNsa5g, DeviceModelFeaturesStatus eSim, DeviceModelFeaturesStatus rcs, List<Binary> binaries){
        this.producerName = producerName;
        this.modelName = modelName;
        this.premiereQuarter = premiereQuarter;
        this.volte = volte;
        this.vowifi = vowifi;
        this.saNsa5g = saNsa5g;
        this.eSim = eSim;
        this.rcs = rcs;
        this.binaries = binaries;
    }

    DeviceModel (String producerName, String modelName, String premiereQuarter, DeviceModelFeaturesStatus volte,
                 DeviceModelFeaturesStatus vowifi, DeviceModelFeaturesStatus saNsa5g, DeviceModelFeaturesStatus eSim, DeviceModelFeaturesStatus rcs, List<Binary> binaries, List<ProjectDetails> projectDetails){
        this.producerName = producerName;
        this.modelName = modelName;
        this.premiereQuarter = premiereQuarter;
        this.volte = volte;
        this.vowifi = vowifi;
        this.saNsa5g = saNsa5g;
        this.eSim = eSim;
        this.rcs = rcs;
        this.binaries = binaries;
        this.projectDetails = projectDetails;
    }



    public DeviceModelFeaturesStatus getEsim() {
        return eSim;
    }

    public void setEsim(DeviceModelFeaturesStatus eSim) {
        this.eSim = eSim;
    }

    public DeviceModelFeaturesStatus getRcs() {
        return rcs;
    }

    public void setRcs(DeviceModelFeaturesStatus rcs) {
        this.rcs = rcs;
    }

    public DeviceModelFeaturesStatus getSaNsa5g() {
        return saNsa5g;
    }

    public void setSaNsa5g(DeviceModelFeaturesStatus saNsa5g) {
        this.saNsa5g = saNsa5g;
    }

    public DeviceModelFeaturesStatus getVolte() {
        return volte;
    }

    public void setVolte(DeviceModelFeaturesStatus volte) {
        this.volte = volte;
    }

    public DeviceModelFeaturesStatus getVowifi() {
        return vowifi;
    }

    public void setVowifi(DeviceModelFeaturesStatus vowifi) {
        this.vowifi = vowifi;
    }

    public int getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(int idDevice) {
        this.idDevice = idDevice;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getPremiereQuarter() {
        return premiereQuarter;
    }

    public void setPremiereQuarter(String premiereQuarter) {
        this.premiereQuarter = premiereQuarter;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public List<ProjectDetails> getProjectDetails(){
        return projectDetails;
    }
    public void setProjectDetails(ArrayList<ProjectDetails> projectDetails){
        this.projectDetails = projectDetails;
    }

    public List<Binary> getBinaries(){
        return binaries;
    }
    public void setBinaries(ArrayList<Binary> binaries){
        this.binaries = binaries;
    }
}

