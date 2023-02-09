package Service;


import Model.AcceptedStatusType;
import Model.Project;
import Payloads.ProjectRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ProjectService {

    Project createProject(ProjectRequest projectRequest);
    Optional<ProjectRequest> updateProject(Integer idProject, ProjectRequest projectRequest);
    Project getSingleProjectById(Integer idProject);
    Project getSingleProjectByName(String projectName);

    List<Project> getProjectsByAcceptedStatus(AcceptedStatusType acceptedStatus);
}
