package Test_Management_App.Controller;

import Test_Management_App.Model.DeviceModel;
import Test_Management_App.Model.TestCase;
import Test_Management_App.Payloads.DeviceModelCreatePayload;
import Test_Management_App.Payloads.DeviceModelUpdatePayload;
import Test_Management_App.Payloads.TestCaseCreatePayload;
import Test_Management_App.Payloads.TestCaseUpdatePayload;
import Test_Management_App.Repository.DeviceModelRepository;
import Test_Management_App.Repository.TestCaseRepository;

import Test_Management_App.Service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testCase")
public class TestCaseController {

    private TestCaseService testCaseService;
    private TestCaseRepository testCaseRepository;


    @Autowired
    public TestCaseController(TestCaseService testCaseService, TestCaseRepository testCaseRepository) {
        this.testCaseService = testCaseService;
        this.testCaseRepository = testCaseRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createTestCase(@RequestBody TestCaseCreatePayload testCaseCreatePayload) {
        TestCase createdTestCase = testCaseService.createTestCase(testCaseCreatePayload);
        return ResponseEntity.ok("Test Case Created");
    }

    @PatchMapping("/update/id/{id}")
    public ResponseEntity<String> updateTestCase(
            @PathVariable("id") int idTestCase,
            @RequestBody TestCaseUpdatePayload partialUpdate) {

        TestCase updatedTestCase = testCaseService.partialUpdateTestCase(idTestCase, partialUpdate);
        return ResponseEntity.ok("Test Case Updated");
    }

    @GetMapping("/allTestCase")
    public ResponseEntity<List<TestCase>> getAllTestCase() {
        List<TestCase> testCases = testCaseService.getAllTestCase();
        if (!testCases.isEmpty()) {
            return ResponseEntity.ok(testCases);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<TestCase> getTestCaseById(@PathVariable int id) {
        TestCase testCase = testCaseService.getTestCaseById(id);
        return ResponseEntity.ok(testCase);
    }

    @GetMapping("/find/name/{testCaseName}")
    public ResponseEntity<TestCase> getTestCaseByTestCaseName(@PathVariable String testCaseName) {
        Optional<TestCase> optionalTestCase = Optional.ofNullable(testCaseService.getTestCaseByTestCaseName(testCaseName));
        return ResponseEntity.of(optionalTestCase);
    }

    @GetMapping("/find/signature/{testCaseSignature}")
    public ResponseEntity<TestCase> getTestCaseBySignature(@PathVariable String testCaseSignature) {
        Optional<TestCase> optionalTestCase = Optional.ofNullable(testCaseService.getTestCaseBySignature(testCaseSignature));
        return ResponseEntity.of(optionalTestCase);
    }

}
