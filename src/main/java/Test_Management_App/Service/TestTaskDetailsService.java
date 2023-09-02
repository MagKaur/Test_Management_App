package Test_Management_App.Service;

import Test_Management_App.Model.TestCase;
import Test_Management_App.Model.TestCaseStatus;
import Test_Management_App.Model.TestTask;
import Test_Management_App.Model.TestTaskDetails;
import Test_Management_App.Payloads.TestTaskCreatePayload;
import Test_Management_App.Payloads.TestTaskDetailsCreatePayload;
import Test_Management_App.Payloads.TestTaskDetailsUpdatePayload;
import Test_Management_App.Payloads.TestTaskUpdatePayload;
import javassist.NotFoundException;
import org.aspectj.weaver.ast.Test;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.util.List;

@Component
public interface TestTaskDetailsService {

    TestTaskDetails createTestTaskDetails(TestTaskDetailsCreatePayload testTaskDetailsCreatePayloadCreatePayload);
    TestTaskDetails partialUpdateTestTaskDetails(int idTestTaskDetails, TestTaskDetailsUpdatePayload testTaskDetailsUpdatePayload);
    TestTaskDetails getTestTaskDetailsByIdTestTaskDetails(int idTestTaskDetails);
    List<TestTaskDetails> getTestTaskDetailsByIdTestTask(TestTask idTestTask);
    List<TestTaskDetails> getTestTaskDetailsByTestCaseStatus(TestCaseStatus testCaseStatus);
    List<TestTaskDetails> getAllTestTaskDetails();
    TestTaskDetails deleteTestTaskDetails(int idTestTaskDetails);

}
