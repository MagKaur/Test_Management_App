package Test_Management_App.Service;

import Test_Management_App.Model.Application;
import Test_Management_App.Payloads.ApplicationPartialUpdatePayload;
import org.springframework.stereotype.Component;

@Component
public interface ApplicationService {

    Application partialUpdateApplication(int id_application, ApplicationPartialUpdatePayload applicationPartialUpdatePayload);
}
