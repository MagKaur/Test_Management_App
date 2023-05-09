package Test_Management_App.Controller;

import Test_Management_App.Model.Application;
import Test_Management_App.Payloads.ApplicationCreatePayload;
import Test_Management_App.Payloads.ApplicationPartialUpdatePayload;
import Test_Management_App.Service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

   @PostMapping
    public ResponseEntity<Application> createApplication(@RequestBody ApplicationCreatePayload applicationCreatePayload) {
        Application createdApplication = applicationService.createApplication(applicationCreatePayload); //TODO: dokończyć po dodaniu service i service impl;
        return ResponseEntity.ok(createdApplication);
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<Application> updateApplication(
            @PathVariable("id") int id_application,
            @RequestBody ApplicationPartialUpdatePayload partialUpdate) {

        Application updatedApplication = applicationService.partialUpdateApplication(id_application, partialUpdate);
        return ResponseEntity.ok(updatedApplication);
    }
}
