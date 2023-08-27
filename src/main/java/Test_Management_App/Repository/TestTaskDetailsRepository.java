package Test_Management_App.Repository;

import Test_Management_App.Model.TestCase;
import Test_Management_App.Model.TestCaseStatus;
import Test_Management_App.Model.TestTask;
import Test_Management_App.Model.TestTaskDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TestTaskDetailsRepository extends JpaRepository<TestTaskDetails, Integer> {

    TestTaskRepository findByIdTestTask(TestTask testTask);
    TestTaskRepository findByIdTestCase(TestCase testCase);
    TestTaskRepository findByTestCaseStatus(TestCaseStatus testCaseStatus);
}
