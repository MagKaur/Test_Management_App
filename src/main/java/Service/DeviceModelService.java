package Service;

import Model.Binary;
import Model.DeviceModel;
import Model.DeviceModelFeaturesStatus;
import Payloads.DeviceModelRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface DeviceModelService {

    DeviceModel createDeviceModel(DeviceModelRequest deviceModelRequest);
    Optional<DeviceModel> updateDeviceModel(Integer idDeviceModel, DeviceModelRequest deviceModelRequest);

    DeviceModel getDeviceModelByProducerName(String producerName);
    DeviceModel getDeviceModelByModelName(String modelName);
    DeviceModel getSingleDeviceModelById(Integer idDeviceModel);
    List<DeviceModel> getDeviceModelByPremiereQuarter(String premiereQuarter);
    List<DeviceModel> getDeviceModelByVoLTE (DeviceModelFeaturesStatus volte);
    List<DeviceModel> getDeviceModelByVoWiFi (DeviceModelFeaturesStatus vowifi);
    List<DeviceModel> getDeviceModelBySaNsa5g(DeviceModelFeaturesStatus saNsa5g);
    List<DeviceModel> getDeviceModelByeSim(DeviceModelFeaturesStatus eSim);
    List<DeviceModel> getDeviceModelByRcs(DeviceModelFeaturesStatus rcs);
}
