package Service;

import Dto.ApplicationDto;
import Exceptions.BlankOrEmptyFieldException;
import Model.Application;
import Payloads.ApplicationRequest;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ApplicationService {

Application createApplication(ApplicationRequest applicationRequest);
Optional<Application> updateApplication(Integer idApplication, ApplicationRequest applicationRequest);

ApplicationDto getSingleApplicationByIdDTO(Integer idApplication) throws ResourceNotFoundException, BlankOrEmptyFieldException;

List <ApplicationDto> getApplicationByNameDTO(String appName);

List <Application> getAllApplications();



//TODO dopisać metody z dto.


}
