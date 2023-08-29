package Test_Management_App.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "test_task_details")
public class TestTaskDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTestTaskDetails;
    @ManyToOne
    @JoinColumn(name = "id_test_task")
    private TestTask idTestTask;
    @ManyToOne
    @JoinColumn(name = "id_test_case")
    private TestCase idTestCase;
    @Column(name = "test_case_status")
    @Enumerated(EnumType.STRING)
    private TestCaseStatus testCaseStatus;

    public TestTaskDetails() {
    }

    public int getIdTestTaskDetails() {
        return idTestTaskDetails;
    }

    public void setIdTestTaskDetails(int idTestTaskDetails) {
        this.idTestTaskDetails = idTestTaskDetails;
    }

    public TestTask getIdTestTask() {
        return idTestTask;
    }

    public void setIdTestTask(TestTask idTestTask) {
        this.idTestTask = idTestTask;
    }

    public TestCase getIdTestCase() {
        return idTestCase;
    }

    public void setIdTestCase(TestCase idTestCase) {
        this.idTestCase = idTestCase;
    }

    public TestCaseStatus getTestCaseStatus() {
        return testCaseStatus;
    }

    public void setTestCaseStatus(TestCaseStatus testCaseStatus) {
        this.testCaseStatus = testCaseStatus;
    }
}
