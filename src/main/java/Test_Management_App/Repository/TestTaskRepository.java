package Test_Management_App.Repository;

import Test_Management_App.Model.Binary;
import Test_Management_App.Model.TestTask;
import Test_Management_App.Model.TestTaskStatus;
import Test_Management_App.Model.UserEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TestTaskRepository extends JpaRepository<TestTask, Integer> {

    List<TestTask> findByIdUserEmployee(UserEmployee idUserEmployee);
    List<TestTask> findByIdBinary(Binary idBinary);
    TestTask findByTestTaskName(String testTaskName);

    List<TestTask> findByTestTaskStatus(TestTaskStatus testTaskStatus);

}
