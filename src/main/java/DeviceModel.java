public class DeviceModel {

    private int id_device;
    private String producer_name;
    private String model_name;
    private String premiere_quarter;
    private char VoLTE;
    private char VoWiFi;
    private char SA_NSA_5G;
    private char e_sim;
    private char RCS;
    private char accepted_status;

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
}

