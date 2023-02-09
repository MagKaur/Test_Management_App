package Service;

import Model.Binary;
import Model.DeviceModelFeaturesStatus;
import Payloads.DeviceModelRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface DeviceModelService {

    Binary createDeviceModel(DeviceModelRequest deviceModelRequest);
    Optional<Binary> updateDeviceModel(Integer idDeviceModel, DeviceModelRequest deviceModelRequest);

    Binary getDeviceModelByProducerName(String producerName);
    Binary getDeviceModelByModelName(String modelName);
    List<Binary> getDeviceModelByPremiereQuarter(String premiereQuarter);
    List<Binary> getDeviceModelByVoLTE (DeviceModelFeaturesStatus volte);
    List<Binary> getDeviceModelByVoWiFi (DeviceModelFeaturesStatus vowifi);
    List<Binary> getDeviceModelBySaNsa5g(DeviceModelFeaturesStatus saNsa5g);
    List<Binary> getDeviceModelByeSim(DeviceModelFeaturesStatus eSim);
    List<Binary> getDeviceModelByRcs(DeviceModelFeaturesStatus rcs);
}
