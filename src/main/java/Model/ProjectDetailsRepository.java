package Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.lang.NonNull;

import java.util.List;

public interface ProjectDetailsRepository extends JpaRepository<ProjectDetails, Integer> {

    @Override
    @RestResource(exported = false)
    void delete (ProjectDetails projectDetails);

    @Override
    @RestResource(exported = false)
    void deleteById(Integer integer);
    //TODO dodać do wymagań wyszukiwania stworzone w repositorach

    List<ProjectDetails>findByFkIdProjectProjectDetails(@NonNull Project fkIdProjectProjectDetails);
    List<ProjectDetails>findByAcceptedStatusDevice(@NonNull AcceptedStatusDevice acceptedStatusDevice);
    List<ProjectDetails>findByFkIdDeviceModelProjectDetailsAndAcceptedStatusDevice(DeviceModel deviceModel, AcceptedStatusDevice acceptedStatusDevice);
}
