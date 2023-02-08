package Controller;

import Repository.ProjectRepository;

import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public class ProjectController {

    private ProjectRepository projectRepository;

    ProjectController(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

}
