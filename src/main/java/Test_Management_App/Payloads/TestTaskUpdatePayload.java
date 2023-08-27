package Test_Management_App.Payloads;

import Test_Management_App.Model.TestTaskStatus;

import java.util.Date;

public class TestTaskUpdatePayload {
    private String testTaskName;
    private Date deadline;
    private TestTaskStatus testTaskStatus;
    private int idUserEmployee;

    private int idBinary;

    public TestTaskUpdatePayload(){}


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

    public int getIdUserEmployee() {
        return idUserEmployee;
    }

    public void setIdUserEmployee(int idUserEmployee) {
        this.idUserEmployee = idUserEmployee;
    }

    public int getIdBinary() {
        return idBinary;
    }

    public void setIdBinary(int idBinary) {
        this.idBinary = idBinary;
    }
}
