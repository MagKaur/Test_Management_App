package Service;

import Model.*;
import Payloads.BinaryRequestApp;
import Payloads.BinaryRequestDevice;
import Payloads.BinaryRequestNewAppModule;
import Repository.ApplicationRepository;
import Repository.BinaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;

@Service
public class BinaryServiceImpl implements BinaryService {

    @Autowired
    private BinaryRepository binaryRepository;
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private DeviceModelService deviceModelService;
    @Autowired
    private NewAppModuleService newAppModuleService;

    @Override
    @Transactional(rollbackFor = IllegalArgumentException.class,
            noRollbackFor = EntityExistsException.class,
            rollbackForClassName = "IllegalArgumentException",
            noRollbackForClassName = "EntityExistsException")
    public Binary createBinaryApp(BinaryRequestApp binaryRequestApp) throws ResourceNotFoundException {
        Binary binary = new Binary();
        Application application = applicationService.getSingleApplicationById(binaryRequestApp.getIdApplication());
        Project project = projectService.getSingleProjectById(binaryRequestApp.getIdProject());
        binary.setBinaryName(binaryRequestApp.getBinaryName());
        binary.setBinaryDescription(binaryRequestApp.getBinaryDescription());
        binary.setBinaryLink(binaryRequestApp.getBinaryLink());
        binary.setFkIdProjectBinary(project);
        binary.setFkIdApplicationBinary(application);
        binary.setBinaryStatus(binaryRequestApp.getBinaryStatus());
        return binaryRepository.save(binary);
    }

    @Override
    @Transactional(
            rollbackFor = IllegalArgumentException.class,
            noRollbackFor = EntityExistsException.class,
            rollbackForClassName = "IllegalArgumentException",
            noRollbackForClassName = "EntityExistsException")
    public Binary createBinaryDevice(BinaryRequestDevice binaryRequestDevice) throws ResourceNotFoundException {
        Binary binary = new Binary();
        Project project = projectService.getSingleProjectById(binaryRequestDevice.getIdProject());
        DeviceModel deviceModel = deviceModelService.getSingleDeviceModelById(binaryRequestDevice.getIdDeviceModel());
        binary.setBinaryName(binary.getBinaryName());
        binary.setBinaryDescription(binaryRequestDevice.getBinaryDescription());
        binary.setBinaryLink(binaryRequestDevice.getBinaryLink());
        binary.setFkIdProjectBinary(project);
        binary.setFkIdDeviceModelBinary(deviceModel);
        binary.setBinaryStatus(binaryRequestDevice.getBinaryStatus());
        return binaryRepository.save(binary);
    }

    @Override
    @Transactional(
            rollbackFor = IllegalArgumentException.class,
            noRollbackFor = EntityExistsException.class,
            rollbackForClassName = "IllegalArgumentException",
            noRollbackForClassName = "EntityExistsException")
    public Binary createBinaryNewAppModule(BinaryRequestNewAppModule binaryRequestNewAppModule) throws ResourceNotFoundException {
        Binary binary = new Binary();
        NewAppModule newAppModule = newAppModuleService.getSingleNewAppModuleByID(binaryRequestNewAppModule.getIdNewAppModule());
        binary.setBinaryName(binary.getBinaryName());
        binary.setBinaryDescription(binaryRequestNewAppModule.getBinaryDescription());
        binary.setBinaryLink(binaryRequestNewAppModule.getBinaryLink());
        binary.setFkIdNewAppModuleBinary(newAppModule);
        binary.setBinaryStatus(binaryRequestNewAppModule.getBinaryStatus());
        return binaryRepository.save(binary);

    }

    @Override
    @Transactional(
            rollbackFor = IllegalArgumentException.class,
            noRollbackFor = EntityExistsException.class,
            rollbackForClassName = "IllegalArgumentException",
            noRollbackForClassName = "EntityExistsException")
    public Optional<Binary> updateBinaryApp(Integer idBinary, BinaryRequestApp binaryRequestApp)
            throws ResourceNotFoundException {
    Optional<Binary> binary = binaryRepository.findById(idBinary);
    if (!binary.isPresent()){
        throw new ResourceNotFoundException();
    } else {
        Application application = applicationService.getSingleApplicationById(binaryRequestApp.getIdApplication());
        Project project = projectService.getSingleProjectById(binaryRequestApp.getIdProject());
        binary.get().setBinaryName(binaryRequestApp.getBinaryName());
        binary.get().setBinaryDescription(binaryRequestApp.getBinaryDescription());
        binary.get().setBinaryLink(binaryRequestApp.getBinaryLink());
        binary.get().setFkIdProjectBinary(project);
        binary.get().setFkIdApplicationBinary(application);
        binary.get().setBinaryStatus(binaryRequestApp.getBinaryStatus());
        binaryRepository.save(binary.get());
        return binary;
    }
    }
    @Override
    @Transactional(
            rollbackFor = IllegalArgumentException.class,
            noRollbackFor = EntityExistsException.class,
            rollbackForClassName = "IllegalArgumentException",
            noRollbackForClassName = "EntityExistsException")
    public Optional<Binary> updateBinaryDevice(Integer idBinary, BinaryRequestDevice binaryRequestDevice)
            throws ResourceNotFoundException {
        Optional<Binary> binary = binaryRepository.findById(idBinary);
        if (!binary.isPresent()){
            throw new ResourceNotFoundException();
        } else {
            DeviceModel deviceModel = deviceModelService.getSingleDeviceModelById(binaryRequestDevice.getIdDeviceModel());
            Project project = projectService.getSingleProjectById(binaryRequestDevice.getIdProject());
            binary.get().setBinaryName(binaryRequestDevice.getBinaryName());
            binary.get().setBinaryDescription(binaryRequestDevice.getBinaryDescription());
            binary.get().setBinaryLink(binaryRequestDevice.getBinaryLink());
            binary.get().setFkIdProjectBinary(project);
            binary.get().setFkIdDeviceModelBinary(deviceModel);
            binary.get().setBinaryStatus(binaryRequestDevice.getBinaryStatus());
            binaryRepository.save(binary.get());
            return binary;
        }
    }

    @Override
    @Transactional(
            rollbackFor = IllegalArgumentException.class,
            noRollbackFor = EntityExistsException.class,
            rollbackForClassName = "IllegalArgumentException",
            noRollbackForClassName = "EntityExistsException")
    public Optional<Binary> updateBinaryNewAppModule(Integer idBinary, BinaryRequestNewAppModule binaryRequestNewAppModule)
            throws ResourceNotFoundException {
        Optional<Binary> binary = binaryRepository.findById(idBinary);
        if (!binary.isPresent()) {
            throw new ResourceNotFoundException();
        } else {
            NewAppModule newAppModule = newAppModuleService.getSingleNewAppModuleByID(binaryRequestNewAppModule.getIdNewAppModule());
            binary.get().setBinaryName(binaryRequestNewAppModule.getBinaryName());
            binary.get().setBinaryDescription(binaryRequestNewAppModule.getBinaryDescription());
            binary.get().setBinaryLink(binaryRequestNewAppModule.getBinaryLink());
            binary.get().setFkIdNewAppModuleBinary(newAppModule);
            binary.get().setBinaryStatus(binaryRequestNewAppModule.getBinaryStatus());
            binaryRepository.save(binary.get());
            return binary;
        }
    }
    @Override
    public List<Binary> getBinaryByStatus(BinaryStatusType binaryStatus){
        return binaryRepository.findByBinaryStatus(binaryStatus);
    }

//TODO zbudowac kontrolery

    @Override
    public List<Binary> getBinaryByAcceptedStatus(AcceptedStatusType binaryStatusType){
        return binaryRepository.findByAcceptedStatus(binaryStatusType);
    }

    @Override
    public List<Binary> getBinaryByIdApplication(Integer idApplication){
        return binaryRepository.findByFkIdApplicationBinary(idApplication);
    }

    @Override
    public List<Binary>getBinaryByFkIdProjectBinary(Integer idProject){
        return binaryRepository.findByFkIdProjectBinary(idProject);
    }
    @Override
    public List<Binary>getBinaryByFkIdDeviceModel(Integer idDeviceModel){
        return binaryRepository.findByFkIdDeviceModelBinary(idDeviceModel);
    }

    @Override
    public List<Binary>getBinaryByFkIdNewAppModule(Integer idNewAppModule){
        return binaryRepository.findByFkIdNewAppModuleBinary(idNewAppModule);
    }

    @Override
    public List<TESTS_ONGOINGview> getBinaryByView(){
        return binaryRepository.getTESTS_ONGOING();
    }
}
