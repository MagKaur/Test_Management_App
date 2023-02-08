package Controller;

import Repository.NewAppModuleRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public class NewAppModuleController {

    private NewAppModuleRepository newAppModuleRepository;

    NewAppModuleController(NewAppModuleRepository newAppModuleRepository){
        this.newAppModuleRepository = newAppModuleRepository;
    }



}
