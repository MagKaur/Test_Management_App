package Controller;

import Repository.ProjectDetailsRepository;
public class ProjectDetailsController {

    private ProjectDetailsRepository projectDetailsRepository;

    ProjectDetailsController(ProjectDetailsRepository projectDetailsRepository){
        this.projectDetailsRepository = projectDetailsRepository;
    }
}
