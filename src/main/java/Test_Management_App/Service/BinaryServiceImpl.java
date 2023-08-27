package Test_Management_App.Service;

import Test_Management_App.Model.Application;
import Test_Management_App.Model.Binary;
import Test_Management_App.Model.BinaryStatusType;
import Test_Management_App.Model.DeviceModel;
import Test_Management_App.Payloads.BinaryCreatePayloadApp;
import Test_Management_App.Payloads.BinaryCreatePayloadDeviceModel;
import Test_Management_App.Payloads.BinaryUpdatePayload;
import Test_Management_App.Repository.ApplicationRepository;
import Test_Management_App.Repository.BinaryRepository;
import Test_Management_App.Repository.DeviceModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BinaryServiceImpl implements BinaryService {

    private final BinaryRepository binaryRepository;
    private final ApplicationRepository applicationRepository;
    private final DeviceModelRepository deviceModelRepository;

    //TODO czy chce takie managed back reference?
    @Autowired
    public  BinaryServiceImpl(BinaryRepository binaryRepository, ApplicationRepository applicationRepository, DeviceModelRepository deviceModelRepository) {
        this.binaryRepository = binaryRepository;
        this.applicationRepository = applicationRepository;
        this.deviceModelRepository = deviceModelRepository;
    }

    public Binary createBinaryApp(BinaryCreatePayloadApp binaryCreatePayloadApp) {
        if (binaryCreatePayloadApp.getBinaryName() == null || isEmptyOrBlank(binaryCreatePayloadApp.getBinaryName())
                || binaryCreatePayloadApp.getBinaryDescription() == null || isEmptyOrBlank(binaryCreatePayloadApp.getBinaryDescription())
                || binaryCreatePayloadApp.getBinaryLink() == null||  isEmptyOrBlank(binaryCreatePayloadApp.getBinaryLink())
                || binaryCreatePayloadApp.getIdApplication() == 0
                || binaryCreatePayloadApp.getBinaryStatusType() == null || isEmptyOrBlank(binaryCreatePayloadApp.getBinaryStatusType().toString())) {
            throw new IllegalArgumentException("One or more fields are empty or blank");
        } else {
            Binary binary = new Binary();
            binary.setBinaryName(binaryCreatePayloadApp.getBinaryName());
            binary.setBinaryDescription(binaryCreatePayloadApp.getBinaryDescription());
            binary.setBinaryLink(binaryCreatePayloadApp.getBinaryLink());


            Application application = applicationRepository.findById(binaryCreatePayloadApp.getIdApplication())
                    .orElseThrow(() -> new EntityNotFoundException("Application with id " + binaryCreatePayloadApp.getIdApplication() + " not found"));

            binary.setIdApplication(application);

            binary.setBinaryStatusType(binaryCreatePayloadApp.getBinaryStatusType());

            return binaryRepository.save(binary);
        }
    }



    @Override
    public Binary createBinaryDeviceModel(BinaryCreatePayloadDeviceModel binaryCreatePayloadDeviceModel) {
        if (binaryCreatePayloadDeviceModel.getBinaryName() == null || isEmptyOrBlank(binaryCreatePayloadDeviceModel.getBinaryName())
                || binaryCreatePayloadDeviceModel.getBinaryDescription() ==null || isEmptyOrBlank(binaryCreatePayloadDeviceModel.getBinaryDescription())
                || binaryCreatePayloadDeviceModel.getBinaryLink() == null || isEmptyOrBlank(binaryCreatePayloadDeviceModel.getBinaryLink())
                || binaryCreatePayloadDeviceModel.getIdDevice() == 0
                || binaryCreatePayloadDeviceModel.getBinaryStatusType().toString() == null || isEmptyOrBlank(binaryCreatePayloadDeviceModel.getBinaryStatusType().toString()))
        {
            throw new IllegalArgumentException("One or more fields are empty or blank");
        }else {
            Binary binary = new Binary();
            binary.setBinaryName(binaryCreatePayloadDeviceModel.getBinaryName());
            binary.setBinaryDescription(binaryCreatePayloadDeviceModel.getBinaryDescription());
            binary.setBinaryLink(binaryCreatePayloadDeviceModel.getBinaryLink());

            DeviceModel deviceModel = deviceModelRepository.findById(binaryCreatePayloadDeviceModel.getIdDevice())
                    .orElseThrow(() -> new EntityNotFoundException("DeviceModel with id " + binaryCreatePayloadDeviceModel.getIdDevice() + " not found"));
            binary.setIdDevice(deviceModel);

            binary.setBinaryStatusType(binaryCreatePayloadDeviceModel.getBinaryStatusType());

            return binaryRepository.save(binary);}

    }  private boolean isEmptyOrBlank(String value) {
        return value == null || value.isEmpty();
    }

    @Override
    public Binary partialUpdateBinary(int idBinary, BinaryUpdatePayload binaryUpdatePayload){
        Optional<Binary> binary = binaryRepository.findById(idBinary);
        if (!binary.isPresent()) {
            throw new ResourceNotFoundException("Binary not found with this id ::"+ idBinary);
        }else {
            if (binaryUpdatePayload.getBinaryName() != null ) {
                binary.get().setBinaryName(binaryUpdatePayload.getBinaryName());
            }
            if (binaryUpdatePayload.getBinaryDescription() != null) {
                binary.get().setBinaryDescription(binaryUpdatePayload.getBinaryDescription());
            }

            if (binaryUpdatePayload.getBinaryLink() != null) {
                binary.get().setBinaryLink(binaryUpdatePayload.getBinaryLink());
            }

            if (binaryUpdatePayload.getIdApplication() >= 0){
                Application application = applicationRepository.findById(binaryUpdatePayload.getIdApplication())
                        .orElseThrow(() -> new EntityNotFoundException("Application with id " + binaryUpdatePayload.getIdApplication() + " not found"));

                binary.get().setIdApplication(application);;
            }

            if (binaryUpdatePayload.getIdDevice() >= 0){
                DeviceModel deviceModel = deviceModelRepository.findById(binaryUpdatePayload.getIdDevice())
                        .orElseThrow(() -> new EntityNotFoundException("Application with id " + binaryUpdatePayload.getIdDevice() + " not found"));

                binary.get().setIdDevice(deviceModel);;
            }


            if (binaryUpdatePayload.getBinaryStatusType() != null) {
                binary.get().setBinaryStatusType(binaryUpdatePayload.getBinaryStatusType());
            }

            return binaryRepository.save(binary.get());
        }
    }

    @Override
    public Binary getBinaryByIdBinary(int idBinary) {
        return binaryRepository.findById(idBinary)
                .orElseThrow(() -> new EntityNotFoundException("Binary with id " + idBinary + " not found"));
    }

    @Override
    public Binary getBinaryByBinaryName(String binaryName) {
        return binaryRepository.findByBinaryName(binaryName);
    }

    @Override
    public List<Binary> getAllBinary() {
        return binaryRepository.findAll();
    }

    @Override
    public List<Binary> getBinaryByIdApplication(Application idApplication) {
        return binaryRepository.findByIdApplication(idApplication);
    }

    @Override
    public List<Binary> getBinaryByIdDevice(DeviceModel idDevice) {
        return binaryRepository.findByIdDevice(idDevice);
    }

    @Override
    public List<Binary> getBinaryByBinaryStatusType(BinaryStatusType binaryStatusType) {
        return binaryRepository.findByBinaryStatusType(binaryStatusType);
    }




}
