package Test_Management_App.Service;

import Test_Management_App.Model.*;
import Test_Management_App.Payloads.TestTaskCreatePayload;
import Test_Management_App.Payloads.TestTaskDetailsUpdatePayload;
import Test_Management_App.Payloads.TestTaskUpdatePayload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TestTaskService {

    TestTask createTestTask(TestTaskCreatePayload testTaskCreatePayload);
    TestTask partialUpdateTestTask(int idTestTask, TestTaskUpdatePayload testTaskUpdatePayload);

    TestTask getTestTaskByIdTestTask(int idTestTask);
    TestTask getTestTaskByTestTaskName(String testTaskName);
    List<TestTask> getAllTestTask();
    List<TestTask>getTestTaskByIdUserEmployee(UserEmployee idUserEmployee);
    List<TestTask>getTestTaskByIdBinary(Binary idBinary);
    List<TestTask>getTestTaskByTestTaskStatus(TestTaskStatus testTaskStatus);

}
