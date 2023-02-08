package Service;

import Model.Binary;
import Model.DeviceModelFeaturesStatus;
import Payloads.DeviceModelRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface DeviceModelService {

    Binary createDeviceModel(DeviceModelRequest deviceModelRequest);
    Optional<Binary> updateDeviceModel(Integer idDeviceModel, DeviceModelRequest deviceModelRequest);

    Binary getDeviceModelByProducerName(String producerName);
    Binary getDeviceModelByModelName(String modelName);
    Binary getDeviceModelByPremiereQuarter(String premiereQuarter);
    Binary getDeviceModelByVoLTE (DeviceModelFeaturesStatus volte);
    Binary getDeviceModelByVoWiFi (DeviceModelFeaturesStatus vowifi);
    Binary getDeviceModelBySaNsa5g(DeviceModelFeaturesStatus saNsa5g);
    Binary getDeviceModelByeSim(DeviceModelFeaturesStatus eSim);
    Binary getDeviceModelByRcs(DeviceModelFeaturesStatus rcs);
}
