package Test_Management_App.Payloads;

import Test_Management_App.Model.DeviceModelFeatureStatus;

public class DeviceModelUpdatePayload {

    private String producerName;

    private String deviceModelName;

    private String premiereQuarter;


    private DeviceModelFeatureStatus volte;

    private DeviceModelFeatureStatus vowifi;

    private DeviceModelFeatureStatus saNsa5g;

    private DeviceModelFeatureStatus eSim;

    private DeviceModelFeatureStatus rcs;

    public DeviceModelUpdatePayload() {
    }


    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getDeviceModelName() {
        return deviceModelName;
    }

    public void setDeviceModelName(String deviceModelName) {
        this.deviceModelName = deviceModelName;
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
