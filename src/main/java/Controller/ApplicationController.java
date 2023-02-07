package Controller;

import Model.Application;
import Model.ApplicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;

import javax.persistence.Entity;
import java.util.List;


@RepositoryRestController
public class ApplicationController {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);
    private ApplicationRepository applicationRepository;


    ApplicationController(ApplicationRepository applicationRepository){

        this.applicationRepository = applicationRepository;
    }

    ResponseEntity<List<Application>> readAllApplications(){
        logger.warn("Exposing all application list");
        return ResponseEntity.ok(applicationRepository.findAll());
    }

}
