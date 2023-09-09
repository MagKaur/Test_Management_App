package Test_Management_App.Model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "test_task")
public class TestTask {

    //TODO dokończyc test task po dodaniu Binary
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTestTask;
    @Column(name = "test_task_name")
    private String testTaskName;
    @Temporal(TemporalType.DATE)
    @Column(name = "deadline")
    private Date deadline;
    @Enumerated(EnumType.STRING)
    @Column(name = "test_task_status")
    private TestTaskStatus testTaskStatus;

    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private UserEmployee idUserEmployee;

    @ManyToOne
    @JoinColumn(name = "id_binary")
    @JsonIgnore
    private Binary idBinary;

    @OneToMany(mappedBy = "idTestTask", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private List<TestTaskDetails> TestTaskDetailsList = new ArrayList<>();

    @OneToMany(mappedBy = "idTestCase", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private List<TestTaskDetails> TestCaseDetailsList = new ArrayList<>();



    public TestTask(){};
    public int getIdTestTask() {
        return idTestTask;
    }

    public void setIdTestTask(int idTestTask) {
        this.idTestTask = idTestTask;
    }

    public String getTestTaskName() {
        return testTaskName;
    }

    public void setTestTaskName(String testTaskName) {
        this.testTaskName = testTaskName;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public TestTaskStatus getTestTaskStatus() {
        return testTaskStatus;
    }

    public void setTestTaskStatus(TestTaskStatus testTaskStatus) {
        this.testTaskStatus = testTaskStatus;
    }

    public UserEmployee getIdUserEmployee() {
        return idUserEmployee;
    }

    public void setIdUserEmployee(UserEmployee idUserEmployee) {
        this.idUserEmployee = idUserEmployee;
    }

    public Binary getIdBinary() {
        return idBinary;
    }

    public void setIdBinary(Binary idBinary) {
        this.idBinary = idBinary;
    }

    public List<TestTaskDetails> getTestTaskDetailsList() {
        return TestTaskDetailsList;
    }
    public void setTestTaskDetailsList(List<TestTaskDetails> testTaskDetailsList) {
        TestTaskDetailsList = testTaskDetailsList;
    }
    public List<TestTaskDetails> getTestCaseDetailsList() {
        return TestCaseDetailsList;
    }
    public void setTestCaseDetailsList(List<TestTaskDetails> testCaseDetailsList) {
        TestCaseDetailsList = testCaseDetailsList;
    }
}
