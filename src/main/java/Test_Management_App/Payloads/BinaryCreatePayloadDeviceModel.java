package Test_Management_App.Payloads;

import Test_Management_App.Model.Application;
import Test_Management_App.Model.BinaryStatusType;
import Test_Management_App.Model.DeviceModel;

public class BinaryCreatePayloadDeviceModel {


    private String binaryName;
    private String binaryDescription;
    private String binaryLink;
    private int idDevice;
    private BinaryStatusType binaryStatusType;

    public BinaryCreatePayloadDeviceModel(){}

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

    public int getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(int idDevice) {
        this.idDevice = idDevice;
    }


    public BinaryStatusType getBinaryStatusType() {
        return binaryStatusType;
    }

    public void setBinaryStatusType(BinaryStatusType binaryStatusType) {
        this.binaryStatusType = binaryStatusType;
    }
}
