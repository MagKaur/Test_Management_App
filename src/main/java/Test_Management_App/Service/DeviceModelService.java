package Test_Management_App.Service;

import Test_Management_App.Model.DeviceModel;
import Test_Management_App.Payloads.DeviceModelCreatePayload;
import Test_Management_App.Payloads.DeviceModelUpdatePayload;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface DeviceModelService {

    DeviceModel createDeviceModel(DeviceModelCreatePayload deviceModelCreatePayload);
    DeviceModel partialUpdateDeviceModel(int idDevice, DeviceModelUpdatePayload deviceModelUpdatePayload);
    DeviceModel getDeviceModelById(int idDevice);
    List<DeviceModel> getDeviceModelByProducerName(String producerName);
    DeviceModel getDeviceModelByModelName(String modelName);
    List<DeviceModel> getAllDeviceModels();
}
