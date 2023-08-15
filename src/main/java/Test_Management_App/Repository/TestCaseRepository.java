package Test_Management_App.Repository;

import Test_Management_App.Model.TestCase;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface TestCaseRepository {

    TestCase findBySignature(String Signature);
    TestCase findByTestCaseName(String testCaseName);
}
