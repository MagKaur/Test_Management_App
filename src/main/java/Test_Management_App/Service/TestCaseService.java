package Test_Management_App.Service;

import Test_Management_App.Model.TestCase;
import Test_Management_App.Payloads.TestCaseCreatePayload;
import Test_Management_App.Payloads.TestCaseUpdatePayload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TestCaseService {

    //TODO + add TestCaseServiceImpl + TestCaseController
    TestCase createTestCase(TestCaseCreatePayload testCaseCreatePayload);
    TestCase partialUpdateTestCase(int idTestCase, TestCaseUpdatePayload testCaseUpdatePayload);
    TestCase getTestCaseById(int idTestCase);
    TestCase getTestCaseByTestCaseName(String testCaseName);
    TestCase getTestCaseBySignature(String signature);
    List<TestCase> getAllTestCase();
}
