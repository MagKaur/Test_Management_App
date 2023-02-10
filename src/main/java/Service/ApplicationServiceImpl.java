package Service;

import Model.Application;
import Payloads.ApplicationRequest;
import Repository.ApplicationRepository;
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
    public Application getSingleApplicationByName(String appName) {
        return applicationRepository.findByAppName(appName);
    }

    @Override
    public List<Application> getAllApplications(){
        return applicationRepository.findAll();
    }

}
