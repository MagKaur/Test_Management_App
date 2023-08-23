package Test_Management_App.Service;

import Test_Management_App.Model.DeviceModel;
import Test_Management_App.Payloads.TestCaseCreatePayload;
import Test_Management_App.Payloads.TestCaseUpdatePayload;
import org.springframework.stereotype.Service;

import Test_Management_App.Model.TestCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import Test_Management_App.Repository.*;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
@Service
public class TestCaseServiceImpl implements TestCaseService{

    private final TestCaseRepository testCaseRepository;

    @Autowired
    public TestCaseServiceImpl(TestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }
    @Override
    public TestCase createTestCase(TestCaseCreatePayload testCaseCreatePayload) {
        if (isEmptyOrBlank(testCaseCreatePayload.getSignature()) || testCaseCreatePayload.getSignature() == null
                || isEmptyOrBlank(testCaseCreatePayload.getTestCaseName()) || testCaseCreatePayload.getTestCaseName() == null
                || isEmptyOrBlank(testCaseCreatePayload.getPreconditions()) || testCaseCreatePayload.getPreconditions() == null
                || isEmptyOrBlank(testCaseCreatePayload.getDescription()) ||  testCaseCreatePayload.getDescription() == null
                || isEmptyOrBlank(testCaseCreatePayload.getExpectedResults()) || testCaseCreatePayload.getExpectedResults() == null)
        {
            throw new IllegalArgumentException("One or more fields are empty or blank");
        } else {

        TestCase testCase = new TestCase();
        testCase.setSignature(testCaseCreatePayload.getSignature());
        testCase.setTestCaseName(testCaseCreatePayload.getTestCaseName());
        testCase.setPreconditions(testCaseCreatePayload.getPreconditions());
        testCase.setDescription(testCaseCreatePayload.getDescription());
        testCase.setExpectedResults(testCaseCreatePayload.getExpectedResults());


        return testCaseRepository.save(testCase);}
    }
    private boolean isEmptyOrBlank(String value) {
        return value == null || value.isEmpty();
    }

    @Override
    public TestCase partialUpdateTestCase(int idTestCase, TestCaseUpdatePayload testCaseUpdatePayload) {
        Optional<TestCase> testCase = testCaseRepository.findById(idTestCase);
        if (!testCase.isPresent()) {
            throw new ResourceNotFoundException("Application not found with this id ::" + idTestCase);
        } else {

            if (testCaseUpdatePayload.getSignature() != null){
                testCase.get().setSignature(testCaseUpdatePayload.getSignature());
            }
            if (testCaseUpdatePayload.getTestCaseName() != null) {
                testCase.get().setTestCaseName(testCaseUpdatePayload.getTestCaseName());
            }
            if (testCaseUpdatePayload.getPreconditions() != null){
                testCase.get().setPreconditions(testCaseUpdatePayload.getPreconditions());
            }
            if (testCaseUpdatePayload.getDescription() != null){
                testCase.get().setDescription(testCaseUpdatePayload.getDescription());
            }
            if (testCaseUpdatePayload.getExpectedResults() != null){
                testCase.get().setExpectedResults(testCaseUpdatePayload.getExpectedResults());
            }

            return testCaseRepository.save(testCase.get());
        }

    }

    @Override
    public TestCase getTestCaseById(int idTestCase) {
        return testCaseRepository.findById(idTestCase)
                .orElseThrow(() -> new EntityNotFoundException("DeviceModel with id " + idTestCase + " not found"));
    }
    @Override
    public TestCase getTestCaseByTestCaseName(String testCaseName) {
        return testCaseRepository.findByTestCaseName(testCaseName);
    }

    @Override
    public TestCase getTestCaseBySignature(String signature) {
        return testCaseRepository.findBySignature(signature);
    }

    @Override
    public List<TestCase> getAllTestCase() {
        return testCaseRepository.findAll();
    }
}
