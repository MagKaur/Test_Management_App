package Test_Management_App.Service;

import Test_Management_App.Model.Binary;
import Test_Management_App.Payloads.BinaryCreatePayloadApp;
import Test_Management_App.Payloads.BinaryCreatePayloadDeviceModel;
import Test_Management_App.Repository.BinaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BinaryServiceImpl implements BinaryService {

    private final BinaryRepository binaryRepository;

    @Autowired
    public  BinaryServiceImpl(BinaryRepository binaryRepository) {
        this.binaryRepository = binaryRepository;
    }

    @Override
    public Binary createBinaryApp(BinaryCreatePayloadApp binaryCreatePayloadApp) {
        if (binaryCreatePayloadApp.getBinaryName() == null || isEmptyOrBlank(binaryCreatePayloadApp.getBinaryName())
                || binaryCreatePayloadApp.getBinaryDescription() == null || isEmptyOrBlank(binaryCreatePayloadApp.getBinaryDescription())
                || binaryCreatePayloadApp.getBinaryLink() == null||  isEmptyOrBlank(binaryCreatePayloadApp.getBinaryLink())
                || binaryCreatePayloadApp.getIdApplication().getAppName() == null || isEmptyOrBlank(binaryCreatePayloadApp.getIdApplication().getAppName())
                || binaryCreatePayloadApp.getBinaryStatusType().toString() == null || isEmptyOrBlank(binaryCreatePayloadApp.getBinaryStatusType().toString()))

                {
            throw new IllegalArgumentException("One or more fields are empty or blank");
        }else {
            Binary binary = new Binary();
            binary.setBinaryName(binaryCreatePayloadApp.getBinaryName());
            binary.setBinaryDescription(binaryCreatePayloadApp.getBinaryDescription());
            binary.setBinaryLink(binaryCreatePayloadApp.getBinaryLink());
            binary.setIdApplication(binaryCreatePayloadApp.getIdApplication());
            binary.setBinaryStatusType(binaryCreatePayloadApp.getBinaryStatusType());

            return binaryRepository.save(binary);
        }
    }
//TODO poprawić create binary dla device niże -> dodać wszędzie funkcję isEmptyOrBlank


    @Override
    public Binary createBinaryApp(int idBinary, BinaryCreatePayloadDeviceModel binaryCreatePayloadDeviceModel) {
        if (binaryCreatePayloadDeviceModel.getBinaryName() == null || isEmptyOrBlank(binaryCreatePayloadDeviceModel.getBinaryName())
                || binaryCreatePayloadDeviceModel.getBinaryDescription() ==null && binaryCreatePayloadDeviceModel.getBinaryDescription().isEmpty()  || binaryCreatePayloadDeviceModel.getBinaryDescription().isBlank()
                || binaryCreatePayloadDeviceModel.getBinaryLink() == null && binaryCreatePayloadDeviceModel.getBinaryLink().isEmpty() || binaryCreatePayloadDeviceModel.getBinaryLink().isBlank() || (binaryCreatePayloadDeviceModel.getIdDevice() == null ||
                (binaryCreatePayloadDeviceModel.getIdDevice().getModelName() == null &&
                        (binaryCreatePayloadDeviceModel.getIdDevice().getModelName().isEmpty() ||
                                binaryCreatePayloadDeviceModel.getIdDevice().getModelName().isBlank())) ||
                binaryCreatePayloadDeviceModel.getBinaryStatusType() == null ||
                (binaryCreatePayloadDeviceModel.getBinaryStatusType().toString() == null &&
                        (binaryCreatePayloadDeviceModel.getBinaryStatusType().toString().isEmpty() ||
                                binaryCreatePayloadDeviceModel.getBinaryStatusType().toString().isBlank()))))
        {
            throw new IllegalArgumentException("One or more fields are empty or blank");
        }else {
            Binary binary = new Binary();
            binary.setBinaryName(binaryCreatePayloadDeviceModel.getBinaryName());
            binary.setBinaryDescription(binaryCreatePayloadDeviceModel.getBinaryDescription());
            binary.setBinaryLink(binaryCreatePayloadDeviceModel.getBinaryLink());
            binary.setIdDevice(binaryCreatePayloadDeviceModel.getIdDevice());
            binary.setBinaryStatusType(binaryCreatePayloadDeviceModel.getBinaryStatusType());

            return binaryRepository.save(binary);}

    }  private boolean isEmptyOrBlank(String value) {
        return value == null || value.isEmpty();
    }


}
