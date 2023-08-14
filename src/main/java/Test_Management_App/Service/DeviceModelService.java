package Test_Management_App.Service;

import Test_Management_App.Model.DeviceModel;
import Test_Management_App.Payloads.DeviceModelCreatePayload;
import Test_Management_App.Payloads.DeviceModelUpdatePayload;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;
@Component
public interface DeviceModelService {

    DeviceModel createDeviceModel(DeviceModelCreatePayload deviceModelCreatePayload);
    DeviceModel partialUpdateDeviceModel(int idDeviceModel, DeviceModelUpdatePayload deviceModelUpdatePayload);
}
