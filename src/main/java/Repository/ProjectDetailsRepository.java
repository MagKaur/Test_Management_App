package Repository;

import Model.AcceptedStatusType;
import Model.DeviceModel;
import Model.Project;
import Model.ProjectDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.lang.NonNull;

import java.util.List;

public interface ProjectDetailsRepository extends JpaRepository<ProjectDetails, Integer> {


    //TODO dodać do wymagań wyszukiwania stworzone w repositorach
    //Czy ja wogole potrzebuje repository project details?

    List<ProjectDetails>findByFkIdProjectProjectDetails(@NonNull Project fkIdProjectProjectDetails);
    List<ProjectDetails>findByAcceptedStatusDevice(@NonNull AcceptedStatusType acceptedStatusDevice);
    List<ProjectDetails>findByFkIdDeviceModelProjectDetailsAndAcceptedStatusDevice(DeviceModel deviceModel, AcceptedStatusType acceptedStatusDevice);
}
