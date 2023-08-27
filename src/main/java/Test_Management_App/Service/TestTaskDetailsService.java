package Test_Management_App.Service;

import Test_Management_App.Model.TestCase;
import Test_Management_App.Model.TestCaseStatus;
import Test_Management_App.Model.TestTask;
import Test_Management_App.Model.TestTaskDetails;
import Test_Management_App.Payloads.TestTaskCreatePayload;
import Test_Management_App.Payloads.TestTaskDetailsCreatePayload;
import Test_Management_App.Payloads.TestTaskUpdatePayload;
import org.aspectj.weaver.ast.Test;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
public interface TestTaskDetailsService {

    TestTaskDetails createTestTaskDetails(TestTaskCreatePayload testTaskCreatePayload);
    TestTaskDetails partialUpdateTestTaskDetails(int idTestTaskDetails, TestTaskUpdatePayload testTaskUpdatePayload);
    TestTaskDetails getTestTaskByIdTestTaskDetails(int idTestTaskDetails);
    TestTaskDetails getTestTaskByIdTestTask(TestTask idTestTask);
    TestTaskDetails getTestTaskByTestCase(TestCase idTestCase);
    TestTaskDetails getTestTaskByTestCaseStatus(TestCaseStatus testCaseStatus);
    TestTaskDetails getAllTestTaskDetails();
    TestTaskDetails deleteTestTaskDetails(int idTestTaskDetails);

}
