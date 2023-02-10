package Service;

import Model.AcceptedStatusType;
import Model.Project;
import Model.ProjectStatusType;
import Payloads.ProjectRequest;
import Repository.ApplicationRepository;
import Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    @Transactional(
            rollbackFor = IllegalArgumentException.class,
            noRollbackFor = EntityExistsException.class,
            rollbackForClassName = "IllegalArgumentException",
            noRollbackForClassName = "EntityExistsException")
    public Project createProject(ProjectRequest projectRequest){
        Project project = new Project();
        project.setProjectName(projectRequest.getProjectName());
        project.setProjectDescription(projectRequest.getProjectDescription());
        project.setProjectStatus(ProjectStatusType.NEW);
        return projectRepository.save(project);
    }

    @Override
    @Transactional(
                    rollbackFor = IllegalArgumentException.class,
                    noRollbackFor = EntityExistsException.class,
                    rollbackForClassName = "IllegalArgumentException",
                    noRollbackForClassName = "EntityExistsException")
    public Optional<Project> updateProject(Integer idProject, ProjectRequest projectRequest)
            throws ResourceNotFoundException {
        Optional<Project> project = projectRepository.findById(idProject);
        if ((!project.isPresent())) {
            throw new ResourceNotFoundException();
        } else {
            project.get().setProjectName(projectRequest.getProjectName());
            project.get().setProjectDescription(projectRequest.getProjectDescription());
            project.get().setProjectStatus(projectRequest.getProjectStatus());
            projectRepository.save(project.get());
            return project;
        }
    }

    @Override
    public Project getSingleProjectById(Integer idProject) throws ResourceNotFoundException{
        return projectRepository.findById(idProject).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Project getSingleProjectByName(String projectName){
        return projectRepository.findByProjectName(projectName);
    }

    @Override
    public List<Project> getSingleProjectByAcceptedStatus(ProjectStatusType projectStatus){
        return projectRepository.findByProjectStatus(projectStatus);
    }

}
