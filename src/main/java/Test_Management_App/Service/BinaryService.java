package Test_Management_App.Service;

import Test_Management_App.Model.Application;
import Test_Management_App.Model.Binary;
import Test_Management_App.Model.BinaryStatusType;
import Test_Management_App.Model.DeviceModel;
import Test_Management_App.Payloads.BinaryCreatePayloadApp;
import Test_Management_App.Payloads.BinaryCreatePayloadDeviceModel;
import Test_Management_App.Payloads.BinaryUpdatePayload;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.util.List;

@Component
public interface BinaryService {
    Binary createBinaryApp(BinaryCreatePayloadApp binaryCreatePayloadApp);
    Binary createBinaryApp(int idBinary, BinaryCreatePayloadDeviceModel binaryCreatePayloadDeviceModel);
    Binary createBinaryDevice(BinaryCreatePayloadDeviceModel binaryCreatePayloadDeviceModel);
    Binary partialUpdateBinary(int idBinary, BinaryUpdatePayload binaryUpdatePayload);
    Binary getBinaryByIdBinary(int idBinary);
    Binary getBinaryByBinaryName(String binaryName);
    List<Binary> getAllBinary();
    List<Binary> getBinaryByIdApplication(Application idApplication);
    List<Binary> getBinaryByIdDevice(DeviceModel idDevice);
    List<Binary> getBinaryByBinaryStatusType(BinaryStatusType binaryStatusType);

}
