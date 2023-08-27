package Test_Management_App.Service;

import Test_Management_App.Model.*;
import Test_Management_App.Payloads.TestTaskCreatePayload;
import Test_Management_App.Payloads.TestTaskUpdatePayload;
import Test_Management_App.Repository.BinaryRepository;
import Test_Management_App.Repository.TestTaskRepository;
import Test_Management_App.Repository.UserEmployeeRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TestTaskServiceImpl implements TestTaskService{

    private final TestTaskRepository testTaskRepository;
    private final UserEmployeeRepository userEmployeeRepository;
    private final BinaryRepository binaryRepository;

    public TestTaskServiceImpl(TestTaskRepository testTaskRepository, UserEmployeeRepository userEmployeeRepository, BinaryRepository binaryRepository) {
        this.testTaskRepository = testTaskRepository;
        this.userEmployeeRepository = userEmployeeRepository;
        this.binaryRepository = binaryRepository;
    }

    public TestTask createTestTask(TestTaskCreatePayload TestTaskCreatePayload) {
        if (TestTaskCreatePayload.getTestTaskName() == null || isEmptyOrBlank(TestTaskCreatePayload.getTestTaskName())
                || TestTaskCreatePayload.getDeadline() == null || isEmptyOrBlank(TestTaskCreatePayload.getDeadline().toString())
                || TestTaskCreatePayload.getTestTaskStatus() == null||  isEmptyOrBlank(TestTaskCreatePayload.getTestTaskStatus().toString())
                || TestTaskCreatePayload.getIdUserEmployee() == 0
                || TestTaskCreatePayload.getIdBinary() == 0)
                {
                        throw new IllegalArgumentException("One or more fields are empty or blank");
        } else {
            TestTask testTask = new TestTask();
            testTask.setTestTaskName(TestTaskCreatePayload.getTestTaskName());
            testTask.setDeadline(TestTaskCreatePayload.getDeadline());
            testTask.setTestTaskStatus(TestTaskCreatePayload.getTestTaskStatus());

            UserEmployee userEmployee = userEmployeeRepository.findById(TestTaskCreatePayload.getIdUserEmployee())
                    .orElseThrow(() -> new EntityNotFoundException("UserEmployee with id " + TestTaskCreatePayload.getIdUserEmployee() + " not found"));
            testTask.setIdUserEmployee(userEmployee);

            Binary binary = binaryRepository.findById(TestTaskCreatePayload.getIdBinary())
                    .orElseThrow(() -> new EntityNotFoundException("Binary with id " + TestTaskCreatePayload.getIdBinary() + " not found"));
            testTask.setIdBinary(binary);

            return testTaskRepository.save(testTask);
        }
    }

    @Override
    public TestTask partialUpdateTestTask(int idTestTask, TestTaskUpdatePayload testTaskUpdatePayload){
        Optional<TestTask> testTask = testTaskRepository.findById(idTestTask);
        if (!testTask.isPresent()) {
            throw new ResourceNotFoundException("Binary not found with this id ::"+ idTestTask);
        }else {
            if (testTaskUpdatePayload.getTestTaskName() != null ) {
                testTask.get().setTestTaskName(testTaskUpdatePayload.getTestTaskName());
            }
            if (testTaskUpdatePayload.getDeadline() != null) {
                testTask.get().setDeadline(testTaskUpdatePayload.getDeadline());
            }

            if (testTaskUpdatePayload.getTestTaskStatus() != null) {
                testTask.get().setTestTaskStatus(testTaskUpdatePayload.getTestTaskStatus());
            }

            if (testTaskUpdatePayload.getIdUserEmployee() >= 0){
                UserEmployee userEmployee = userEmployeeRepository.findById(testTaskUpdatePayload.getIdUserEmployee())
                        .orElseThrow(() -> new EntityNotFoundException("UserEmployee with id " + testTaskUpdatePayload.getIdUserEmployee() + " not found"));
                testTask.get().setIdUserEmployee(userEmployee);;
            }

            if (testTaskUpdatePayload.getIdBinary() >= 0){
                Binary binary = binaryRepository.findById(testTaskUpdatePayload.getIdBinary())
                        .orElseThrow(() -> new EntityNotFoundException("Binary with id " + testTaskUpdatePayload.getIdBinary() + " not found"));

                testTask.get().setIdBinary(binary);;
            }


            return testTaskRepository.save(testTask.get());
        }
    }
    private boolean isEmptyOrBlank(String value) {
        return value == null || value.isEmpty();
    }

    @Override
    public TestTask getTestTaskByIdTestTask(int idTestTask) {
        return testTaskRepository.findById(idTestTask)
                .orElseThrow(() -> new EntityNotFoundException("TestTask with id " + idTestTask + " not found"));
    }

    @Override
    public TestTask getTestTaskByTestTaskName(String testTaskName) {
        return testTaskRepository.findByTestTaskName(testTaskName);
    }

    @Override
    public List<TestTask> getAllTestTask() {
        return testTaskRepository.findAll();
    }

    @Override
    public List<TestTask>getTestTaskByTestTaskStatus(TestTaskStatus testTaskStatus){
        return testTaskRepository.findByTestTaskStatus(testTaskStatus);
    }

    @Override
    public List<TestTask>getTestTaskByIdUserEmployee(UserEmployee userEmployee){
        return testTaskRepository.findByIdUserEmployee(userEmployee);
    }

    @Override
    public List<TestTask>getTestTaskByIdBinary(Binary idBinary){
        return testTaskRepository.findByIdBinary(idBinary);
    }

}
