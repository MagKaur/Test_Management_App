package Test_Management_App.Service;

import Test_Management_App.Model.DeviceModel;
import Test_Management_App.Model.DeviceModelFeatureStatus;
import Test_Management_App.Payloads.DeviceModelCreatePayload;
import Test_Management_App.Payloads.DeviceModelUpdatePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import Test_Management_App.Repository.*;
import java.util.Optional;

@Service
public class DeviceModelServiceImpl implements DeviceModelService {

    private final DeviceModelRepository deviceModelRepository;

    @Autowired
    public DeviceModelServiceImpl(DeviceModelRepository deviceModelRepository) {
        this.deviceModelRepository = deviceModelRepository;
    }

    @Override
    public DeviceModel createDeviceModel(DeviceModelCreatePayload deviceModelCreatePayload) {
        if (isEmptyOrBlank(deviceModelCreatePayload.getProducerName()) || isEmptyOrBlank(deviceModelCreatePayload.getDeviceModelName()) || isEmptyOrBlank(deviceModelCreatePayload.getPremiereQuarter()) ||
                deviceModelCreatePayload.getVolte() == null ||
                deviceModelCreatePayload.getVowifi() == null ||
                deviceModelCreatePayload.getSaNsa5g() == null ||
                deviceModelCreatePayload.geteSim() == null ||
                deviceModelCreatePayload.getRcs() == null) {

            throw new IllegalArgumentException("One or more fields are empty or blank");
        }

        DeviceModel deviceModel = new DeviceModel();
        deviceModel.setProducerName(deviceModelCreatePayload.getProducerName());
        deviceModel.setDeviceModelName(deviceModelCreatePayload.getDeviceModelName());
        deviceModel.setPremiereQuarter(deviceModelCreatePayload.getPremiereQuarter());
        deviceModel.setVolte(deviceModelCreatePayload.getVolte());
        deviceModel.setVowifi(deviceModelCreatePayload.getVowifi());
        deviceModel.setSaNsa5g(deviceModelCreatePayload.getSaNsa5g());
        deviceModel.seteSim(deviceModelCreatePayload.geteSim());
        deviceModel.setRcs(deviceModelCreatePayload.geteSim());

        return deviceModelRepository.save(deviceModel);
    }

    private boolean isEmptyOrBlank(String value) {
        return value == null || value.isEmpty();
    }

    @Override
    public DeviceModel partialUpdateDeviceModel(int idDeviceModel, DeviceModelUpdatePayload deviceModelUpdatePayload) {
        Optional<DeviceModel> deviceModel = deviceModelRepository.findById(idDeviceModel);
        if (!deviceModel.isPresent()) {
            throw new ResourceNotFoundException("Application not found with this id ::" + idDeviceModel);
        } else {
            if (deviceModelUpdatePayload.getDeviceModelName() != null) {
                deviceModel.get().setDeviceModelName(deviceModelUpdatePayload.getDeviceModelName());
            }
            if (deviceModelUpdatePayload.getProducerName() != null){
                deviceModel.get().setProducerName(deviceModelUpdatePayload.getProducerName());
            }
            if (deviceModelUpdatePayload.getPremiereQuarter() != null){
                deviceModel.get().setPremiereQuarter(deviceModelUpdatePayload.getPremiereQuarter());
            }
            if (deviceModelUpdatePayload.getVolte() != null){
                deviceModel.get().setVolte(deviceModelUpdatePayload.getVolte());
            }
            if (deviceModelUpdatePayload.getVowifi() != null){
                deviceModel.get().setVowifi(deviceModelUpdatePayload.getVowifi());
            }
            if (deviceModelUpdatePayload.getSaNsa5g() != null){
                deviceModel.get().setSaNsa5g(deviceModelUpdatePayload.getSaNsa5g());
            }
            if (deviceModelUpdatePayload.geteSim() != null){
                deviceModel.get().seteSim(deviceModelUpdatePayload.geteSim());
            }
            if (deviceModelUpdatePayload.getRcs() != null){
                deviceModel.get().setRcs(deviceModelUpdatePayload.getRcs());
            }
            return deviceModelRepository.save(deviceModel.get());
        }

    }
}











