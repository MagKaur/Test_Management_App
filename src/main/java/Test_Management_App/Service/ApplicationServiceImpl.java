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
        if (applicationCreatePayload.getApp_name().isEmpty() || applicationCreatePayload.getApp_name().isBlank()
                || applicationCreatePayload.getTechnology_description().isEmpty()  || applicationCreatePayload.getTechnology_description().isBlank()
                || applicationCreatePayload.getFunctionality_description().isEmpty() || applicationCreatePayload.getFunctionality_description().isBlank() ) {
            throw new IllegalArgumentException("One or more fields are empty or blank");
        }else {
            Application application = new Application();
            application.setApp_name(applicationCreatePayload.getApp_name());
            application.setTechnology_description(applicationCreatePayload.getTechnology_description());
            application.setFunctionality_description(applicationCreatePayload.getFunctionality_description());

            return applicationRepository.save(application);
        }
    }

    @Override
    public Application partialUpdateApplication(int id_application, ApplicationUpdatePayload applicationUpdatePayload){
        Optional<Application> application = applicationRepository.findById(id_application);
        if (!application.isPresent()) {
            throw new ResourceNotFoundException("Application not found with this id ::"+ id_application);
        }else {
            if (applicationUpdatePayload.getApp_name() != null) {
                application.get().setApp_name(applicationUpdatePayload.getApp_name());
            }
            if (applicationUpdatePayload.getFunctionality_description() != null) {
                application.get().setFunctionality_description(applicationUpdatePayload.getFunctionality_description());
            }

            if (applicationUpdatePayload.getTechnology_description() != null) {
                application.get().setTechnology_description(applicationUpdatePayload.getTechnology_description());
            }
            return applicationRepository.save(application.get());
        }
    }

}
