package Test_Management_App.Service;

import Test_Management_App.Model.*;
import Test_Management_App.Payloads.*;
import Test_Management_App.Repository.*;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TestTaskDetailsImpl implements TestTaskDetailsService{

    private final TestTaskDetailsRepository testTaskDetailsRepository;
    private final TestTaskRepository testTaskRepository;
    private final TestCaseRepository testCaseRepository;

    public TestTaskDetailsImpl(TestTaskDetailsRepository testTaskDetailsRepository, TestTaskRepository testTaskRepository, TestCaseRepository testCaseRepository) {
        this.testTaskDetailsRepository = testTaskDetailsRepository;
        this.testTaskRepository = testTaskRepository;
        this.testCaseRepository = testCaseRepository;
    }

    public TestTaskDetails createTestTaskDetails(TestTaskDetailsCreatePayload testTaskDetailsCreatePayload) {
        if (testTaskDetailsCreatePayload.getIdTestTask() <= 0
                || testTaskDetailsCreatePayload.getIdTestCase() <= 0
                || testTaskDetailsCreatePayload.getTestCaseStatus() == null || isEmptyOrBlank(testTaskDetailsCreatePayload.getTestCaseStatus().toString()))
        {
            throw new IllegalArgumentException("One or more fields are empty or blank");
        } else {
            TestTaskDetails testTaskDetails = new TestTaskDetails();

            TestTask testTask = testTaskRepository.findById(testTaskDetailsCreatePayload.getIdTestTask())
                    .orElseThrow(() -> new EntityNotFoundException("TestTask with id " + testTaskDetailsCreatePayload.getIdTestTask() + " not found"));
            testTaskDetails.setIdTestTask(testTask);

            TestCase testCase = testCaseRepository.findById(testTaskDetailsCreatePayload.getIdTestCase())
                    .orElseThrow(() -> new EntityNotFoundException("TestCase with id " + testTaskDetailsCreatePayload.getIdTestCase() + " not found"));
            testTaskDetails.setIdTestCase(testCase);

            testTaskDetails.setTestCaseStatus(testTaskDetailsCreatePayload.getTestCaseStatus());

            return testTaskDetailsRepository.save(testTaskDetails);
        }
    }

    @Override
    public TestTaskDetails partialUpdateTestTaskDetails(int idTestTaskDetails, TestTaskDetailsUpdatePayload testTaskDetailsUpdatePayload){
        Optional<TestTaskDetails> testTaskDetails = testTaskDetailsRepository.findById(idTestTaskDetails);
        if (!testTaskDetails.isPresent()) {
            throw new ResourceNotFoundException("TestTaskDetails not found with this id ::"+ idTestTaskDetails);
        }else {
            if (testTaskDetailsUpdatePayload.getIdTestTask() > 0 ) {
                TestTask testTask = testTaskRepository.findById(testTaskDetailsUpdatePayload.getIdTestTask())
                        .orElseThrow(() -> new EntityNotFoundException("Test Task with id " + testTaskDetailsUpdatePayload.getIdTestTask() + " not found"));
                testTaskDetails.get().setIdTestTask(testTask);
            }

            if (testTaskDetailsUpdatePayload.getIdTestCase() > 0 ) {
                TestCase testCase = testCaseRepository.findById(testTaskDetailsUpdatePayload.getIdTestCase())
                        .orElseThrow(() -> new EntityNotFoundException("Test Case with id " + testTaskDetailsUpdatePayload.getIdTestCase() + " not found"));
                testTaskDetails.get().setIdTestCase(testCase);
            }

            if (testTaskDetailsUpdatePayload.getTestCaseStatus() != null) {
                testTaskDetails.get().setTestCaseStatus(testTaskDetailsUpdatePayload.getTestCaseStatus());
            }

            return testTaskDetailsRepository.save(testTaskDetails.get());
        }
    }
    private boolean isEmptyOrBlank(String value) {
        return value == null || value.isEmpty();
    }

    @Override
    public TestTaskDetails getTestTaskDetailsByIdTestTaskDetails(int idTestTaskDetails) {
        return testTaskDetailsRepository.findById(idTestTaskDetails)
                .orElseThrow(() -> new EntityNotFoundException("TestTastDetails with id " + idTestTaskDetails + " not found"));
    }
    @Override
    public List<TestTaskDetails> getTestTaskDetailsByIdTestTask(TestTask idTestTask) {
        return testTaskDetailsRepository.findByIdTestTask(idTestTask);
    }

    @Override
    public TestTaskDetails getTestTaskDetailsByIdTestCase(TestCase idTestCase) {
        return testTaskDetailsRepository.findByIdTestCase(idTestCase);
    }

    @Override
    public List<TestTaskDetails> getTestTaskDetailsByTestCaseStatus(TestCaseStatus testCaseStatus) {
        return testTaskDetailsRepository.findByTestCaseStatus(testCaseStatus);
    }

    @Override
    public List<TestTaskDetails> getAllTestTaskDetails() {
        return testTaskDetailsRepository.findAll();
    }

    @Override
    public TestTaskDetails deleteTestTaskDetails(int idTestTaskDetails) {
        Optional<TestTaskDetails> task = testTaskDetailsRepository.findById(idTestTaskDetails);
        if (!task.isPresent()) {
            throw new ResourceNotFoundException("TestTaskDetails with ID " + idTestTaskDetails + " not found");
        } else {
            testTaskDetailsRepository.delete(task.get());
            return task.get();
        }
    }
}
