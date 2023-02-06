package Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

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
    private VoLTEstatus volte;
    @Column(name = "vowifi")
    @NotNull(message = "VoWiFi indication must not be null")
    @NotBlank(message = "VoWiFi indication must not be empty")
    @Enumerated(EnumType.ORDINAL)
    private VoWiFistatus vowifi;
    @Column(name = "sa_nsa_5g")
    @NotNull(message = "sa_nsa_5G indication must not be null")
    @NotBlank(message = "sa_nsa_5G indication must not be empty")
    @Enumerated(EnumType.ORDINAL)
    private SaNsa5gStatus saNsa5g;
    @Column(name = "e_sim")
    @NotNull(message = "e-sim indication must not be null")
    @NotBlank(message = "e-sim indication must not be empty")
    @Enumerated(EnumType.ORDINAL)
    private EsimStatus eSim;
    @Column(name = "rcs")
    @NotNull(message = "rcs indication must not be null")
    @NotBlank(message = "rcs indication must not be empty")
    @Enumerated(EnumType.ORDINAL)
    private RcsStatus rcs;

    @OneToMany(mappedBy = "fkIdDeviceModelProjectDetails", cascade = CascadeType.ALL)
    @JsonBackReference
    private ArrayList<ProjectDetails> projectDetails = new ArrayList<>();
    @OneToMany(mappedBy = "fkIdDeviceModelBinary", cascade = CascadeType.ALL)
    @JsonBackReference
    private ArrayList<Binary> binaries = new ArrayList<>();

    protected DeviceModel(){};

    DeviceModel (int idDevice, String producerName, String modelName, String premiereQuarter, VoLTEstatus volte,
                 VoWiFistatus vowifi,SaNsa5gStatus saNsa5g, EsimStatus eSim, RcsStatus rcs){
        this.idDevice = idDevice;
        this.producerName = producerName;
        this.modelName = modelName;
        this.premiereQuarter = premiereQuarter;
        this.volte = volte;
        this.vowifi = vowifi;
        this.saNsa5g = saNsa5g;
        this.eSim = eSim;
        this.rcs = rcs;
    }

    DeviceModel (int idDevice, String producerName, String modelName, String premiereQuarter, VoLTEstatus volte,
                 VoWiFistatus vowifi,SaNsa5gStatus saNsa5g, EsimStatus eSim, RcsStatus rcs, ArrayList<Binary> binaries){
        this.idDevice = idDevice;
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

    DeviceModel (int idDevice, String producerName, String modelName, String premiereQuarter, VoLTEstatus volte,
                 VoWiFistatus vowifi,SaNsa5gStatus saNsa5g, EsimStatus eSim, RcsStatus rcs, ArrayList<Binary> binaries, ArrayList<ProjectDetails> projectDetails){
        this.idDevice = idDevice;
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



    public EsimStatus getEsim() {
        return eSim;
    }

    public void setEsim(EsimStatus eSim) {
        this.eSim = eSim;
    }

    public RcsStatus getRcs() {
        return rcs;
    }

    public void setRcs(RcsStatus rcs) {
        this.rcs = rcs;
    }

    public SaNsa5gStatus getSaNsa5g() {
        return saNsa5g;
    }

    public void setSaNsa5g(SaNsa5gStatus saNsa5g) {
        this.saNsa5g = saNsa5g;
    }

    public VoLTEstatus getVolte() {
        return volte;
    }

    public void setVolte(VoLTEstatus volte) {
        this.volte = volte;
    }

    public VoWiFistatus getVowifi() {
        return vowifi;
    }

    public void setVowifi(VoWiFistatus vowifi) {
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

    public ArrayList<ProjectDetails> getProjectDetails(){
        return projectDetails;
    }
    public void setProjectDetails(ArrayList<ProjectDetails> projectDetails){
        this.projectDetails = projectDetails;
    }

    public ArrayList<Binary> getBinaries(){
        return binaries;
    }
    public void setBinaries(ArrayList<Binary> binaries){
        this.binaries = binaries;
    }
}

