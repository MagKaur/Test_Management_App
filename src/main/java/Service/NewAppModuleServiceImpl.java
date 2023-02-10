package Service;

import Model.Application;
import Model.NewAppModule;
import Payloads.NewAppModuleRequest;
import Repository.NewAppModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;


@Service
public class NewAppModuleServiceImpl implements NewAppModuleService{

    @Autowired
    private NewAppModuleRepository newAppModuleRepository;
    @Autowired
    private ApplicationService applicationService;


    @Override
    @Transactional(
            rollbackFor = IllegalArgumentException.class,
            noRollbackFor = EntityExistsException.class,
            rollbackForClassName = "IllegalArgumentException",
            noRollbackForClassName = "EntityExistsException")
    public NewAppModule createNewAppModule(NewAppModuleRequest newAppModuleRequest) throws ResourceNotFoundException {
        NewAppModule newAppModule = new NewAppModule();
        Application application = applicationService.getSingleApplicationById(newAppModuleRequest.getIdApplication());
        newAppModule.setModuleName(newAppModuleRequest.getModuleName());
        newAppModule.setModuleDescription(newAppModuleRequest.getModuleDescription());
        newAppModule.setFkIdApplicationNewAppModule(application);
        return newAppModuleRepository.save(newAppModule);

    }

    @Override
    @Transactional(
            rollbackFor = IllegalArgumentException.class,
            noRollbackFor = EntityExistsException.class,
            rollbackForClassName = "IllegalArgumentException",
            noRollbackForClassName = "EntityExistsException")
    public Optional<NewAppModule> updateNewAppModule(Integer idNewAppModule, NewAppModuleRequest newAppModuleRequest)
            throws ResourceNotFoundException{
        Optional<NewAppModule> newAppModule = newAppModuleRepository.findById(idNewAppModule);
        if (!newAppModule.isPresent()){
            throw new ResourceNotFoundException();
        } else {
            Application application = applicationService.getSingleApplicationById(newAppModuleRequest.getIdApplication());
            newAppModule.get().setModuleName(newAppModuleRequest.getModuleName());
            newAppModule.get().setModuleDescription(newAppModuleRequest.getModuleDescription());
            newAppModule.get().setFkIdApplicationNewAppModule(application);
            newAppModuleRepository.save(newAppModule.get());
            return newAppModule;
        }
    }

    @Override
    public NewAppModule getSingleNewAppModuleByID(Integer idNewAppModule) throws ResourceNotFoundException{
        return newAppModuleRepository.findById(idNewAppModule).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public NewAppModule getSingleNewAppModuleByName(String moduleName){
        return newAppModuleRepository.findByModuleName(moduleName);
    }

    @Override
    public List<NewAppModule> getListNewAppModuleByAppId(Integer idApplication){
        return newAppModuleRepository.findByFkIdApplicationNewAppModule(idApplication);
    }



}
