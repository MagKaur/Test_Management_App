package Test_Management_App.Service;

import Test_Management_App.Model.Application;
import Test_Management_App.Payloads.ApplicationPartialUpdatePayload;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import Test_Management_App.Repository.*;

@Service
public class ApplicationServiceImpl  implements ApplicationService{


    private final ApplicationRepository applicationRepository;

    public  ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Application partialUpdateApplication(int id_application, ApplicationPartialUpdatePayload applicationPartialUpdatePayload){
        Application application = applicationRepository.findById(id_application)
                .orElseThrow(() -> new ResourceNotFoundException("Application not found for this id ::"+ id_application));
        if (applicationPartialUpdatePayload.getApp_name() != null) {
                application.setApp_name(applicationPartialUpdatePayload.getApp_name());
        }
        if (applicationPartialUpdatePayload.getFunctionality_description() != null) {
            application.setApp_name(applicationPartialUpdatePayload.getFunctionality_description());
        }
        if (applicationPartialUpdatePayload.getTechnology_description() != null) {
            application.setApp_name(applicationPartialUpdatePayload.getFunctionality_description());
        }
        final Application updateApplication = applicationRepository.save(application);
        return updateApplication;
    }

}
