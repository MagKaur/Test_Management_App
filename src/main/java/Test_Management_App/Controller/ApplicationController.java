package Test_Management_App.Controller;

import Test_Management_App.Model.Application;
import Test_Management_App.Payloads.ApplicationCreatePayload;
import Test_Management_App.Payloads.ApplicationUpdatePayload;
import Test_Management_App.Repository.ApplicationRepository;
import Test_Management_App.Service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {


    private ApplicationService applicationService;

    private ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationController(ApplicationService applicationService, ApplicationRepository applicationRepository) {
        this.applicationService = applicationService;
        this.applicationRepository = applicationRepository;
    }

   @PostMapping("/create")
    public ResponseEntity<Application> createApplication(@RequestBody ApplicationCreatePayload applicationCreatePayload) {
        Application createdApplication = applicationService.createApplication(applicationCreatePayload); //TODO: dokończyć po dodaniu service i service impl;
        return ResponseEntity.ok(createdApplication);
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<Application> updateApplication(
            @PathVariable("id") int id_application,
            @RequestBody ApplicationUpdatePayload partialUpdate) {

        Application updatedApplication = applicationService.partialUpdateApplication(id_application, partialUpdate);
        return ResponseEntity.ok(updatedApplication);
    }

    @GetMapping("/allApplications")
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }


}
