package Test_Management_App.Service;

import Test_Management_App.Model.Application;
import Test_Management_App.Model.DeviceModel;
import Test_Management_App.Payloads.ApplicationCreatePayload;
import Test_Management_App.Payloads.ApplicationUpdatePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import Test_Management_App.Repository.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl  implements ApplicationService{


    private final ApplicationRepository applicationRepository;

    @Autowired
    public  ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }
    @Override
    public Application createApplication(ApplicationCreatePayload applicationCreatePayload) {
        if (applicationCreatePayload.getAppName() == null || isEmptyOrBlank(applicationCreatePayload.getAppName())
                || applicationCreatePayload.getTechnologyDescription() == null || isEmptyOrBlank(applicationCreatePayload.getAppName())
                || applicationCreatePayload.getFunctionalityDescription() == null || isEmptyOrBlank((applicationCreatePayload.getFunctionalityDescription())))
        {
            throw new IllegalArgumentException("One or more fields are empty, blank or null");
        }else {
            Application application = new Application();
            application.setAppName(applicationCreatePayload.getAppName());
            application.setTechnologyDescription(applicationCreatePayload.getTechnologyDescription());
            application.setFunctionalityDescription(applicationCreatePayload.getFunctionalityDescription());

            return applicationRepository.save(application);}
    }

    private boolean isEmptyOrBlank(String value) {
        return value == null || value.isEmpty();
    }


    @Override
    public Application partialUpdateApplication(int idApplication, ApplicationUpdatePayload applicationUpdatePayload){
        Optional<Application> application = applicationRepository.findById(idApplication);
        if (!application.isPresent()) {
            throw new ResourceNotFoundException("Application not found with this id ::"+ idApplication);
        }else {
            if (applicationUpdatePayload.getAppName() != null ) {
                application.get().setAppName(applicationUpdatePayload.getAppName());
            }
            if (applicationUpdatePayload.getFunctionalityDescription() != null) {
                application.get().setFunctionalityDescription(applicationUpdatePayload.getFunctionalityDescription());
            }

            if (applicationUpdatePayload.getTechnologyDescription() != null) {
                application.get().setTechnologyDescription(applicationUpdatePayload.getTechnologyDescription());
            }
            return applicationRepository.save(application.get());
        }
    }
    @Override
    public Application getSingleAppById(int idApplication) {
        return applicationRepository.findById(idApplication)
                .orElseThrow(() -> new EntityNotFoundException("DeviceModel with id " + idApplication + " not found"));
    }
    @Override
    public Application getApplicationByAppName(String appName) {
        return applicationRepository.findByAppName(appName);
    }
    @Override
    public List<Application> getAllApplication() {
        return applicationRepository.findAll();
    }




}
