package Test_Management_App.Payloads;

import Test_Management_App.Model.Application;
import Test_Management_App.Model.BinaryStatusType;
import Test_Management_App.Model.DeviceModel;

public class BinaryUpdatePayload {


    public class BinaryCreatePayload {

        private String binaryName;
        private String binaryDescription;
        private String binaryLink;
        private Application idApplication;
        private DeviceModel idDevice;

        private BinaryStatusType binaryStatusType;

        public BinaryCreatePayload() {
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
}
