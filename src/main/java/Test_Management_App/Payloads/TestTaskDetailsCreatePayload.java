package Test_Management_App.Payloads;

import Test_Management_App.Model.TestCaseStatus;

import javax.persistence.Column;

public class TestTaskDetailsCreatePayload {

    private int idTestTask;

    private int idTestCase;

    private TestCaseStatus testCaseStatus;

    public TestTaskDetailsCreatePayload() {
    }


    public int getIdTestTask() {
        return idTestTask;
    }

    public void setIdTestTask(int idTestTask) {
        this.idTestTask = idTestTask;
    }

    public int getIdTestCase() {
        return idTestCase;
    }

    public void setIdTestCase(int idTestCase) {
        this.idTestCase = idTestCase;
    }

    public TestCaseStatus getTestCaseStatus() {
        return testCaseStatus;
    }

    public void setTestCaseStatus(TestCaseStatus testCaseStatus) {
        this.testCaseStatus = testCaseStatus;
    }
}
