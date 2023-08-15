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
import java.util.Optional;

@RestController
@RequestMapping("/application")
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
        Application createdApplication = applicationService.createApplication(applicationCreatePayload);
        return ResponseEntity.ok(createdApplication);
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<Application> updateApplication(
            @PathVariable("id") int idApplication,
            @RequestBody ApplicationUpdatePayload partialUpdate) {

        Application updatedApplication = applicationService.partialUpdateApplication(idApplication, partialUpdate);
        return ResponseEntity.ok(updatedApplication);
    }

    @GetMapping("/allApplication")
    public ResponseEntity<List<Application>> getAllApplication() {
        List<Application> application = applicationRepository.findAll();
        if (!application.isEmpty()) {
            return ResponseEntity.ok().body(application);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<Application> getSingleAppById(@PathVariable int id) {
        Optional<Application> optionalApplication = applicationRepository.findById(id);
        return optionalApplication.map(application -> ResponseEntity.ok().body(application)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/find/name/{appName}")
    public ResponseEntity<Application> getApplicationByAppName(@PathVariable String appName) {
        Application application = applicationRepository.findByAppName(appName);
        if (application == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(application);
        }
    }

}
