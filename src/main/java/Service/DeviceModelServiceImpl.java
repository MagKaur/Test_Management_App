package Service;

import Model.DeviceModel;
import Model.DeviceModelFeaturesStatus;
import Payloads.DeviceModelRequest;
import Repository.DeviceModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;


@Service
public class DeviceModelServiceImpl implements DeviceModelService{

    @Autowired
    private DeviceModelRepository deviceModelRepository;

    @Override
    @Transactional(
            rollbackFor = IllegalArgumentException.class,
            noRollbackFor = EntityExistsException.class,
            rollbackForClassName = "IllegalArgumentException",
            noRollbackForClassName = "EntityExistsException")
    public DeviceModel createDeviceModel(DeviceModelRequest deviceModelRequest) throws ResourceNotFoundException{
        DeviceModel deviceModel = new DeviceModel();
        deviceModel.setProducerName(deviceModelRequest.getProducer_name());
        deviceModel.setModelName(deviceModelRequest.getModelName());
        deviceModel.setPremiereQuarter(deviceModelRequest.getPremiereQuarter());
        deviceModel.setVolte(deviceModelRequest.getVolte());
        deviceModel.setVowifi(deviceModelRequest.getVowifi());
        deviceModel.setSaNsa5g(deviceModelRequest.getSaNsa5g());
        deviceModel.setEsim(deviceModelRequest.getESim());
        deviceModel.setRcs(deviceModelRequest.getRcs());
        return deviceModelRepository.save(deviceModel);
    }

    @Override
    @Transactional(rollbackFor = IllegalArgumentException.class,
            noRollbackFor = EntityExistsException.class,
            rollbackForClassName = "IllegalArgumentException",
            noRollbackForClassName = "EntityExistsException")
    public Optional<DeviceModel> updateDeviceModel(Integer idDeviceModel, DeviceModelRequest deviceModelRequest)
            throws ResourceNotFoundException{
        Optional<DeviceModel> deviceModel = deviceModelRepository.findById(idDeviceModel);
        if(!deviceModel.isPresent()){
            throw new ResourceNotFoundException();
        } else{
            deviceModel.get().setProducerName(deviceModelRequest.getProducer_name());
            deviceModel.get().setModelName(deviceModelRequest.getModelName());
            deviceModel.get().setVolte(deviceModelRequest.getVolte());
            deviceModel.get().setVowifi(deviceModelRequest.getVowifi());
            deviceModel.get().setSaNsa5g(deviceModelRequest.getSaNsa5g());
            deviceModel.get().setEsim(deviceModelRequest.getESim());
            deviceModel.get().setRcs(deviceModelRequest.getRcs());
            deviceModelRepository.save(deviceModel.get());
            return deviceModel;
        }
    }

    @Override
    public DeviceModel getDeviceModelByProducerName(String producerName){
        return deviceModelRepository.findByProducerName(producerName);
    }

    @Override
    public  DeviceModel getDeviceModelByModelName(String modelName){
        return deviceModelRepository.findByModelName(modelName);
    }

    @Override
    public  DeviceModel getSingleDeviceModelById(Integer idDeviceModel) throws ResourceNotFoundException{
        return deviceModelRepository.findById(idDeviceModel).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<DeviceModel> getDeviceModelByPremiereQuarter(String premiereQuarter){
        return deviceModelRepository.findByPremiereQuarter(premiereQuarter);
    }

    @Override
    public List<DeviceModel> getDeviceModelByVoLTE(DeviceModelFeaturesStatus volte){
        return deviceModelRepository.findByVolte(volte);
    }
    @Override
    public List<DeviceModel> getDeviceModelByVoWiFi(DeviceModelFeaturesStatus vowifi){
        return deviceModelRepository.findByVowifi(vowifi);
    }
    @Override
    public List<DeviceModel> getDeviceModelBySaNsa5g(DeviceModelFeaturesStatus saNsa5g){
        return deviceModelRepository.findBySaNsa5g(saNsa5g);
    }
    @Override
    public List<DeviceModel> getDeviceModelByeSim(DeviceModelFeaturesStatus eSim){
        return deviceModelRepository.findByeSim(eSim);
    }
    @Override
    public List<DeviceModel> getDeviceModelByRcs(DeviceModelFeaturesStatus rcs){
        return deviceModelRepository.findByRcs(rcs);
    }
}
