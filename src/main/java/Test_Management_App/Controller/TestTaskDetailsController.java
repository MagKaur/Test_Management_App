package Test_Management_App.Controller;

import Test_Management_App.Model.*;
import Test_Management_App.Payloads.BinaryCreatePayloadApp;
import Test_Management_App.Payloads.BinaryUpdatePayload;
import Test_Management_App.Payloads.TestTaskDetailsCreatePayload;
import Test_Management_App.Payloads.TestTaskDetailsUpdatePayload;
import Test_Management_App.Repository.BinaryRepository;
import Test_Management_App.Repository.TestTaskDetailsRepository;
import Test_Management_App.Service.BinaryService;
import Test_Management_App.Service.TestTaskDetailsService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/testTaskDetails")
public class TestTaskDetailsController {

    private TestTaskDetailsRepository testTaskDetailsRepository;
    private TestTaskDetailsService testTaskDetailsService;

    @Autowired
    public TestTaskDetailsController(TestTaskDetailsService testTaskDetailsService, TestTaskDetailsRepository testTaskDetailsRepository) {
        this.testTaskDetailsRepository = testTaskDetailsRepository;
        this.testTaskDetailsService=testTaskDetailsService;
    }
    @PostMapping("/createTestTaskDetails")
    public ResponseEntity<String> createTestTaskDetails(@RequestBody TestTaskDetailsCreatePayload testTaskDetailsCreatePayload) {
        TestTaskDetails createdTestTaskDetails = testTaskDetailsService.createTestTaskDetails(testTaskDetailsCreatePayload);
        return ResponseEntity.ok("Test Task Details created");
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> UpdateTestTaskDetails(
            @PathVariable("id") int idTestTaskDetails,
            @RequestBody TestTaskDetailsUpdatePayload partialUpdate) {

        TestTaskDetails updatedTestTaskDetails = testTaskDetailsService.partialUpdateTestTaskDetails(idTestTaskDetails, partialUpdate);
        return ResponseEntity.ok("Test Task Details updated");
    }
    @GetMapping("/allTestTaskDetails")
    public ResponseEntity<List<TestTaskDetails>> getAllTestTaskDetails() {
        List<TestTaskDetails> testTaskDetailsList = testTaskDetailsService.getAllTestTaskDetails();
        if (!testTaskDetailsList.isEmpty()) {
            return ResponseEntity.ok().body(testTaskDetailsList);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<TestTaskDetails> getTestTaskDetailsByIdTestTaskDetails(@PathVariable int id) {
        Optional<TestTaskDetails> optionalTestTaskDetails = Optional.ofNullable(testTaskDetailsService.getTestTaskDetailsByIdTestTaskDetails(id));
        return optionalTestTaskDetails.map(testTaskDetails -> ResponseEntity.ok().body(testTaskDetails)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/find/byTestTask/{idTestTask}")
    public ResponseEntity<List<TestTaskDetails>> getTestTaskDetailsByIdTestTask(@PathVariable TestTask idTestTask) {
        List<TestTaskDetails> testTaskDetailsList = testTaskDetailsService.getTestTaskDetailsByIdTestTask(idTestTask);
        if (!testTaskDetailsList.isEmpty()) {
            return ResponseEntity.ok().body(testTaskDetailsList);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/find/byTestTaskStatus/{testCaseStatus}")
    public ResponseEntity<List<TestTaskDetails>> getTestTaskDetailsByTestCaseStatus(@PathVariable TestCaseStatus testCaseStatus) {
        List<TestTaskDetails> testTaskDetailsList = testTaskDetailsService.getTestTaskDetailsByTestCaseStatus(testCaseStatus);
        if (!testTaskDetailsList.isEmpty()) {
            return ResponseEntity.ok().body(testTaskDetailsList);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTestTaskDetails(@PathVariable int id) {

            TestTaskDetails testTaskDetails = testTaskDetailsService.deleteTestTaskDetails(id);
            if (testTaskDetails == null) {
            return ResponseEntity.notFound().build();
        } else {
                return ResponseEntity.ok("Test Task Details with ID " + id + " deleted");
        }
    }
}
