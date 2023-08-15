package Test_Management_App.Model;
import javax.persistence.*;
import Test_Management_App.Model.DeviceModelFeatureStatus;

@Entity
@Table(name = "device_model")
public class DeviceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDevice;

    @Column(name = "producer_name")
    private String producerName;
    @Column(name = "model_name")
    private String modelName;
    @Column(name = "premiere_quarter")
    private String premiereQuarter;
    @Enumerated(EnumType.STRING)
    @Column(name = "volte")
    private DeviceModelFeatureStatus volte;
    @Enumerated(EnumType.STRING)
    @Column(name = "vowifi")
    private DeviceModelFeatureStatus vowifi;
    @Enumerated(EnumType.STRING)
    @Column(name = "sa_nsa_5g")
    private DeviceModelFeatureStatus saNsa5g;
    @Enumerated(EnumType.STRING)
    @Column(name = "e_sim")
    private DeviceModelFeatureStatus eSim;
    @Enumerated(EnumType.STRING)
    @Column(name = "rcs")
    private DeviceModelFeatureStatus rcs;

    public DeviceModel(){
    }
    public int getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(int idDevice) {
        this.idDevice = idDevice;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
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

    public DeviceModelFeatureStatus getVolte() {
        return volte;
    }

    public void setVolte(DeviceModelFeatureStatus volte) {
        this.volte = volte;
    }

    public DeviceModelFeatureStatus getVowifi() {
        return vowifi;
    }

    public void setVowifi(DeviceModelFeatureStatus vowifi) {
        this.vowifi = vowifi;
    }

    public DeviceModelFeatureStatus getSaNsa5g() {
        return saNsa5g;
    }

    public void setSaNsa5g(DeviceModelFeatureStatus saNsa5g) {
        this.saNsa5g = saNsa5g;
    }

    public DeviceModelFeatureStatus geteSim() {
        return eSim;
    }

    public void seteSim(DeviceModelFeatureStatus eSim) {
        this.eSim = eSim;
    }

    public DeviceModelFeatureStatus getRcs() {
        return rcs;
    }

    public void setRcs(DeviceModelFeatureStatus rcs) {
        this.rcs = rcs;
    }

}

