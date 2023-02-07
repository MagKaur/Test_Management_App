package Controller;

import Model.ProjectDetailsRepository;
public class ProjectDetailsController {

    private ProjectDetailsRepository projectDetailsRepository;

    ProjectDetailsController(ProjectDetailsRepository projectDetailsRepository){
        this.projectDetailsRepository = projectDetailsRepository;
    }
}
