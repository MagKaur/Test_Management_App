package Service;

import Model.Application;
import Payloads.ApplicationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ApplicationService {

Application createApplication(ApplicationRequest applicationRequest);
Optional<Application> updateApplication(Integer idApplication, ApplicationRequest applicationRequest);
Application getSingleApplicationById(Integer idApplication);
Application getSingleApplicationByName(String appName);

//TODO dopisać metody z dto.


}
