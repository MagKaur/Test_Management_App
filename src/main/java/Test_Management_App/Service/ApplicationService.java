package Test_Management_App.Service;

import Test_Management_App.Model.Application;
import Test_Management_App.Payloads.ApplicationCreatePayload;
import Test_Management_App.Payloads.ApplicationUpdatePayload;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;

@Component
public interface ApplicationService {

    Application createApplication(ApplicationCreatePayload applicationCreatePayload);
    Application partialUpdateApplication(int idApplication, ApplicationUpdatePayload applicationUpdatePayload);


}
