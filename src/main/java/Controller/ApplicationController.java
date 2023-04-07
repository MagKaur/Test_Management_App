package Controller;

import Model.Application;
import Repository.ApplicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import java.util.List;


public class ApplicationController {

    private ApplicationRepository applicationRepository;

    ApplicationController(ApplicationRepository applicationRepository){

        this.applicationRepository = applicationRepository;
    }





}
