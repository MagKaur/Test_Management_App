package Test_Management_App.Repository;

import Test_Management_App.Model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface TestCaseRepository extends JpaRepository<TestCase, Integer> {

    TestCase findBySignature(String Signature);
    TestCase findByTestCaseName(String testCaseName);
}
