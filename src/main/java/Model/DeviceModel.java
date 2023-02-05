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
    //TODO Do Project Details tez w respository blokade usuniecia
    //TODO Przeniesc accepted device model status do project details i usunąc zmienne z kodu
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_device")
    private int id_device;
    @Column(name = "producer_name")
    @NotNull (message = "Producer name must not be null")
    @NotBlank(message = "Producer name must not be empty")
    private String producer_name;
    @Column(name = "model_name")
    @NotNull(message = "Model name must not be null")
    @NotBlank(message = "Model name must not be empty")
    private String model_name;
    @Column(name = "premiere_quarter")
    @NotNull(message = "Premiere Quarter must not be null")
    @NotBlank(message = "Premiere Quarter must not be empty")
    private String premiere_quarter;
    @Column(name = "volte")
    @NotNull(message = "VoLTE indication must not be null")
    @NotBlank(message = "VoLTE indication must not be empty")
    //TODO czy do tych charów nie lepiej takze dodac enum?
    private char volte;
    @Column(name = "vowifi")
    @NotNull(message = "VoWiFi indication must not be null")
    @NotBlank(message = "VoWiFi indication must not be empty")
    private char vowifi;
    @Column(name = "sa_nsa_5g")
    @NotNull(message = "sa_nsa_5G indication must not be null")
    @NotBlank(message = "sa_nsa_5G indication must not be empty")
    private char sa_nsa_5g;
    @Column(name = "e_sim")
    @NotNull(message = "e-sim indication must not be null")
    @NotBlank(message = "e-sim indication must not be empty")
    private char e_sim;
    @Column(name = "rcs")
    @NotNull(message = "rcs indication must not be null")
    @NotBlank(message = "rcs indication must not be empty")
    private char rcs;
    @Column(name = "accepted_status")
    private char accepted_status;

    @OneToMany(mappedBy = "fk_id_deviceModelProjectDetails", cascade = CascadeType.ALL)
    @JsonBackReference
    private ArrayList<ProjectDetails> projectDetails = new ArrayList<>();
    @OneToMany(mappedBy = "fk_id_deviceModelBinary", cascade = CascadeType.ALL)
    @JsonBackReference
    private ArrayList<Binary> binaries = new ArrayList<>();

    protected DeviceModel(){};

    DeviceModel (int id_device, String producer_name, String model_name, String premiere_quarter, char volte,
                 char vowifi,char sa_nsa_5g, char rcs, char accepted_status){
        this.id_device = id_device;
        this.producer_name = producer_name;
        this.model_name = model_name;
        this.premiere_quarter = premiere_quarter;
        this.volte = volte;
        this.vowifi = vowifi;
        this.sa_nsa_5g = sa_nsa_5g;
        this.rcs = rcs;
        this. accepted_status = accepted_status;
    }

    DeviceModel (int id_device, String producer_name, String model_name, String premiere_quarter, char volte,
                 char vowifi,char sa_nsa_5g, char rcs){
        this.id_device = id_device;
        this.producer_name = producer_name;
        this.model_name = model_name;
        this.premiere_quarter = premiere_quarter;
        this.volte = volte;
        this.vowifi = vowifi;
        this.sa_nsa_5g = sa_nsa_5g;
        this.rcs = rcs;
    }

    DeviceModel (int id_device, String producer_name, String model_name, String premiere_quarter, char volte,
                 char vowifi,char sa_nsa_5g, char rcs, ArrayList<Binary> binaries){
        this.id_device = id_device;
        this.producer_name = producer_name;
        this.model_name = model_name;
        this.premiere_quarter = premiere_quarter;
        this.volte = volte;
        this.vowifi = vowifi;
        this.sa_nsa_5g = sa_nsa_5g;
        this.rcs = rcs;
        this.binaries = binaries;
    }

    DeviceModel (int id_device, String producer_name, String model_name, String premiere_quarter, char volte,
                 char vowifi,char sa_nsa_5g, char rcs, ArrayList<Binary> binaries, ArrayList<ProjectDetails> projectDetails){
        this.id_device = id_device;
        this.producer_name = producer_name;
        this.model_name = model_name;
        this.premiere_quarter = premiere_quarter;
        this.volte = volte;
        this.vowifi = vowifi;
        this.sa_nsa_5g = sa_nsa_5g;
        this.rcs = rcs;
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

    public char getRcs() {
        return rcs;
    }

    public void setRcs(char rcs) {
        this.rcs = rcs;
    }

    public char getSa_nsa_5g() {
        return sa_nsa_5g;
    }

    public void setSa_nsa_5g(char sa_nsa_5g) {
        this.sa_nsa_5g = sa_nsa_5g;
    }

    public char getVolte() {
        return volte;
    }

    public void setVolte(char volte) {
        this.volte = volte;
    }

    public char getVowifi() {
        return vowifi;
    }

    public void setVowifi(char vowifi) {
        this.vowifi = vowifi;
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

