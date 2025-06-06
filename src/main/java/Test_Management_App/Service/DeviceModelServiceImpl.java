package Test_Management_App.Service;

import Test_Management_App.Model.DeviceModel;
import Test_Management_App.Payloads.DeviceModelCreatePayload;
import Test_Management_App.Payloads.DeviceModelUpdatePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import Test_Management_App.Repository.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
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
        if (isEmptyOrBlank(deviceModelCreatePayload.getProducerName()) || deviceModelCreatePayload.getProducerName() == null
                || isEmptyOrBlank(deviceModelCreatePayload.getModelName()) || deviceModelCreatePayload.getModelName() == null
                || isEmptyOrBlank(deviceModelCreatePayload.getPremiereQuarter()) || deviceModelCreatePayload.getPremiereQuarter() == null
                || deviceModelCreatePayload.getVolte() == null || isEmptyOrBlank(deviceModelCreatePayload.getVolte().toString())
                || deviceModelCreatePayload.getVowifi() == null || isEmptyOrBlank(deviceModelCreatePayload.getVowifi().toString())
                || deviceModelCreatePayload.getSaNsa5g() == null || isEmptyOrBlank(deviceModelCreatePayload.getSaNsa5g().toString())
                || deviceModelCreatePayload.geteSim() == null ||isEmptyOrBlank(deviceModelCreatePayload.geteSim().toString())
                || isEmptyOrBlank(deviceModelCreatePayload.getRcs().toString())|| deviceModelCreatePayload.getRcs() == null)
        {
            throw new IllegalArgumentException("One or more fields are empty or blank");
        } else {
        DeviceModel deviceModel = new DeviceModel();
        deviceModel.setProducerName(deviceModelCreatePayload.getProducerName());
        deviceModel.setModelName(deviceModelCreatePayload.getModelName());
        deviceModel.setPremiereQuarter(deviceModelCreatePayload.getPremiereQuarter());
        deviceModel.setVolte(deviceModelCreatePayload.getVolte());
        deviceModel.setVowifi(deviceModelCreatePayload.getVowifi());
        deviceModel.setSaNsa5g(deviceModelCreatePayload.getSaNsa5g());
        deviceModel.seteSim(deviceModelCreatePayload.geteSim());
        deviceModel.setRcs(deviceModelCreatePayload.getRcs());

        return deviceModelRepository.save(deviceModel);}
    }

    private boolean isEmptyOrBlank(String value) {
        return value == null || value.isEmpty();
    }

    @Override
    public DeviceModel partialUpdateDeviceModel(int idDevice, DeviceModelUpdatePayload deviceModelUpdatePayload) {
        Optional<DeviceModel> deviceModel = deviceModelRepository.findById(idDevice);
        if (!deviceModel.isPresent()) {
            throw new ResourceNotFoundException("Device Model not found with this id ::" + idDevice);
        } else {

            if (deviceModelUpdatePayload.getProducerName() != null){
                deviceModel.get().setProducerName(deviceModelUpdatePayload.getProducerName());
            }
            if (deviceModelUpdatePayload.getModelName() != null) {
                deviceModel.get().setModelName(deviceModelUpdatePayload.getModelName());
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
    @Override
    public DeviceModel getDeviceModelById(int idDevice) {
        return deviceModelRepository.findById(idDevice)
                .orElseThrow(() -> new EntityNotFoundException("DeviceModel with id " + idDevice + " not found"));
    }
    @Override
    public List<DeviceModel> getDeviceModelByProducerName(String producerName){
        return deviceModelRepository.findByProducerName(producerName);
    }
    @Override
    public  DeviceModel getDeviceModelByModelName(String modelName){
        return deviceModelRepository.findByModelName(modelName);
    }
    @Override
    public List<DeviceModel> getAllDeviceModels() {
        return deviceModelRepository.findAll();
    }
}











