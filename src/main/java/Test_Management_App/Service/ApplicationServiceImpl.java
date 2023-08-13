package Test_Management_App.Service;

import Test_Management_App.Model.Application;
import Test_Management_App.Payloads.ApplicationCreatePayload;
import Test_Management_App.Payloads.ApplicationUpdatePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import Test_Management_App.Repository.*;

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
        if (applicationCreatePayload.getAppName().isEmpty() || applicationCreatePayload.getAppName().isBlank()
                || applicationCreatePayload.getTechnologyDescription().isEmpty()  || applicationCreatePayload.getTechnologyDescription().isBlank()
                || applicationCreatePayload.getFunctionalityDescription().isEmpty() || applicationCreatePayload.getFunctionalityDescription().isBlank() ) {
            throw new IllegalArgumentException("One or more fields are empty or blank");
        }else {
            Application application = new Application();
            application.setAppName(applicationCreatePayload.getAppName());
            application.setTechnologyDescription(applicationCreatePayload.getTechnologyDescription());
            application.setFunctionalityDescription(applicationCreatePayload.getFunctionalityDescription());

            return applicationRepository.save(application);
        }
    }

    @Override
    public Application partialUpdateApplication(int idApplication, ApplicationUpdatePayload applicationUpdatePayload){
        Optional<Application> application = applicationRepository.findById(idApplication);
        if (!application.isPresent()) {
            throw new ResourceNotFoundException("Application not found with this id ::"+ idApplication);
        }else {
            if (applicationUpdatePayload.getAppName() != null) {
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


}
