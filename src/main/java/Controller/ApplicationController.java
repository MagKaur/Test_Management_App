package Controller;

import Model.Application;
import Repository.ApplicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import java.util.List;


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
