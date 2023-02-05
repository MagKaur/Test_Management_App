package Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "device_models", schema = "mango")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class DeviceModel { //TODO czy do device model czy Application lub application module dodawac enum?
    //TODO Czy do Project Details dodawać w respository blokade usuniecia jak np w binary czy Project?

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_device")
    @NotNull
    private int id_device;
    @Column(name = "producer_name")
    @NotBlank(message = "Producer name must not be empty")
    private String producer_name;
    @Column(name = "model_name")
    @NotBlank(message = "Model name must not be empty")
    private String model_name;
    @Column(name = "premiere_quarter")
    @NotBlank(message = "Premiere Quarter must not be empty")
    private String premiere_quarter;
    @Column(name = "volte")
    @NotNull //TODO Not Null na char?
    private char VoLTE;
    @Column(name = "vowifi")
    @NotNull
    private char VoWiFi;
    @Column(name = "sa_nsa_5g")
    @NotNull
    private char SA_NSA_5G;
    @Column(name = "e_sim")
    @NotNull
    private char e_sim;
    @Column(name = "RCS")
    @NotNull
    private char RCS;
    @Column(name = "accepted_status")
    private char accepted_status;

    @OneToMany(mappedBy = "fk_id_deviceModelProjectDetails", cascade = CascadeType.ALL)
    @JsonBackReference
    private ArrayList<ProjectDetails> projectDetails = new ArrayList<>();
    @OneToMany(mappedBy = "fk_id_deviceModelBinary", cascade = CascadeType.ALL)
    @JsonBackReference
    private ArrayList<Binary> binaries = new ArrayList<>();

    protected DeviceModel(){};

    DeviceModel (int id_device, String producer_name, String model_name, String premiere_quarter, char VoLTE,
                 char VoWiFi,char SA_NSA_5G, char RCS, char accepted_status){
        this.id_device = id_device;
        this.producer_name = producer_name;
        this.model_name = model_name;
        this.premiere_quarter = premiere_quarter;
        this.VoLTE = VoLTE;
        this.VoWiFi = VoWiFi;
        this.SA_NSA_5G = SA_NSA_5G;
        this.RCS = RCS;
        this. accepted_status = accepted_status;
    }

    DeviceModel (int id_device, String producer_name, String model_name, String premiere_quarter, char VoLTE,
                 char VoWiFi,char SA_NSA_5G, char RCS){
        this.id_device = id_device;
        this.producer_name = producer_name;
        this.model_name = model_name;
        this.premiere_quarter = premiere_quarter;
        this.VoLTE = VoLTE;
        this.VoWiFi = VoWiFi;
        this.SA_NSA_5G = SA_NSA_5G;
        this.RCS = RCS;
    }

    DeviceModel (int id_device, String producer_name, String model_name, String premiere_quarter, char VoLTE,
                 char VoWiFi,char SA_NSA_5G, char RCS, ArrayList<Binary> binaries){
        this.id_device = id_device;
        this.producer_name = producer_name;
        this.model_name = model_name;
        this.premiere_quarter = premiere_quarter;
        this.VoLTE = VoLTE;
        this.VoWiFi = VoWiFi;
        this.SA_NSA_5G = SA_NSA_5G;
        this.RCS = RCS;
        this.binaries = binaries;
    }

    DeviceModel (int id_device, String producer_name, String model_name, String premiere_quarter, char VoLTE,
                 char VoWiFi,char SA_NSA_5G, char RCS, ArrayList<Binary> binaries, ArrayList<ProjectDetails> projectDetails){
        this.id_device = id_device;
        this.producer_name = producer_name;
        this.model_name = model_name;
        this.premiere_quarter = premiere_quarter;
        this.VoLTE = VoLTE;
        this.VoWiFi = VoWiFi;
        this.SA_NSA_5G = SA_NSA_5G;
        this.RCS = RCS;
        this.binaries = binaries;
        this.projectDetails = projectDetails;
    }

    public char getAccepted_status() {
        return accepted_status;
    }

    public void setAccepted_status(char accepted_status) {
        this.accepted_status = accepted_status;
    }

    public char getE_sim() {
        return e_sim;
    }

    public void setE_sim(char e_sim) {
        this.e_sim = e_sim;
    }

    public char getRCS() {
        return RCS;
    }

    public void setRCS(char RCS) {
        this.RCS = RCS;
    }

    public char getSA_NSA_5G() {
        return SA_NSA_5G;
    }

    public void setSA_NSA_5G(char SA_NSA_5G) {
        this.SA_NSA_5G = SA_NSA_5G;
    }

    public char getVoLTE() {
        return VoLTE;
    }

    public void setVoLTE(char voLTE) {
        VoLTE = voLTE;
    }

    public char getVoWiFi() {
        return VoWiFi;
    }

    public void setVoWiFi(char voWiFi) {
        VoWiFi = voWiFi;
    }

    public int getId_device() {
        return id_device;
    }

    public void setId_device(int id_device) {
        this.id_device = id_device;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getPremiere_quarter() {
        return premiere_quarter;
    }

    public void setPremiere_quarter(String premiere_quarter) {
        this.premiere_quarter = premiere_quarter;
    }

    public String getProducer_name() {
        return producer_name;
    }

    public void setProducer_name(String producer_name) {
        this.producer_name = producer_name;
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

