package Service;

import Dto.ApplicationDto;
import Model.Application;
import Model.Binary;
import Model.NewAppModule;
import Payloads.ApplicationRequest;
import Repository.ApplicationRepository;
import Repository.NewAppModuleRepository;
import Repository.BinaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;


@Service
public class ApplicationServiceImpl implements ApplicationService{


    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private NewAppModuleRepository newAppModuleRepository;
    @Autowired
    private BinaryRepository binaryRepository;

    @Override
    @Transactional(
            rollbackFor = IllegalArgumentException.class,
            noRollbackFor = EntityExistsException.class,
            rollbackForClassName = "IllegalArgumentException",
            noRollbackForClassName = "EntityExistsException")
    public Application createApplication(ApplicationRequest applicationRequest){
        Application application = new Application();
        application.setAppName(applicationRequest.getAppName());
        application.setTechnologyDescription(application.getTechnologyDescription());
        application.setFunctionalityDescription(application.getFunctionalityDescription());
        return applicationRepository.save(application);
    }


    @Override
    @Transactional(
            rollbackFor = IllegalArgumentException.class,
            noRollbackFor = EntityExistsException.class,
            rollbackForClassName = "IllegalArgumentException",
            noRollbackForClassName = "EntityExistsException")
    public Optional<Application> updateApplication(Integer idApplication, ApplicationRequest applicationRequest)
            throws ResourceNotFoundException {
        Optional<Application> application = applicationRepository.findById(idApplication);
        if (!application.isPresent()) {
            throw new ResourceNotFoundException();
        } else {
            application.get().setAppName(applicationRequest.getAppName());
            application.get().setTechnologyDescription(applicationRequest.getTechnologyDescription());
            application.get().setFunctionalityDescription(applicationRequest.getFunctionalityDescription());
            applicationRepository.save(application.get());
            return application;
        }
    }
    @Override
    public Application getSingleApplicationById(Integer idApplication) throws ResourceNotFoundException{
            return applicationRepository.findById(idApplication).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public ApplicationDto getSingleApplicationByIdDTO(Integer idApplication) throws ResourceNotFoundException{
        Optional <Application> app = applicationRepository.findById(idApplication);
        if (!app.isPresent()) {
            throw new ResourceNotFoundException();
        } else
        { Application application = app.get(); //get() wyciąga application z opakowania Optional (matrioszka Optional -> Application)
                    if (application.getAppName().isEmpty() || application.getAppName().isBlank()){
                        throw new ResourceNotFoundException();
                    //TODO napisać własny typ błędu by obsłuzyć empty i blank app name i wstawić za ResourceNotFoundException();
                    } else {
                        List<NewAppModule> newAppModuleList = newAppModuleRepository.findByFkIdApplicationNewAppModule(idApplication);
                        List<Binary> binariesList = binaryRepository.findByFkIdApplicationBinary(idApplication);
                        ApplicationDto AppDTO = new ApplicationDto(application.getAppName(),
                                application.getTechnologyDescription(), application.getFunctionalityDescription(),
                                newAppModuleList, binariesList);
                        return AppDTO;
                    }
        }
    }

    @Override
    public Application getSingleApplicationByName(String appName) {
        return applicationRepository.findByAppName(appName);
    }

    @Override
    public  ApplicationDto getSingleApplicationByNameDTO(String appName){
        Application app = applicationRepository.findByAppName(appName);
        if (app.getAppName().isEmpty() || app.getAppName().isBlank()) throw new ResourceNotFoundException();
        //TODO napisać własny typ błędu by obsłuzyć empty i blank app name i wstawić za ResourceNotFoundException();
        else {
            List<NewAppModule> newAppModuleList = newAppModuleRepository.findByFkIdApplicationNewAppModule(app.getIdApplication());
            List<Binary> binariesList = binaryRepository.findByFkIdApplicationBinary(app.getIdApplication());
            ApplicationDto AppDTO = new ApplicationDto(app.getAppName(),
                    app.getTechnologyDescription(), app.getFunctionalityDescription(),
                    newAppModuleList, binariesList);
            return AppDTO;
        }
    }

    @Override
    public List<Application> getAllApplications(){
        return applicationRepository.findAll();
    }

}
