package Test_Management_App.Service;

import Test_Management_App.Model.Application;
import Test_Management_App.Payloads.ApplicationCreatePayload;
import Test_Management_App.Payloads.ApplicationPartialUpdatePayload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ApplicationService {

    public Application createApplication(ApplicationCreatePayload createPayload);
    Application partialUpdateApplication(int id_application, ApplicationPartialUpdatePayload applicationPartialUpdatePayload);

    List<Application> getAllApplications();
}
