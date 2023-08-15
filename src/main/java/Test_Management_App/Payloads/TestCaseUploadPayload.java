package Test_Management_App.Payloads;

import javax.persistence.Column;

public class TestCaseUploadPayload {

    private String signature;

    private String testCaseName;

    private String preconditions;

    private String description;

    private String expectedResults;

    public TestCaseUploadPayload(){
    }


    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTestCaseName() {
        return testCaseName;
    }

    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public String getPreconditions() {
        return preconditions;
    }

    public void setPreconditions(String preconditions) {
        this.preconditions = preconditions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpectedResults() {
        return expectedResults;
    }

    public void setExpectedResults(String expectedResults) {
        this.expectedResults = expectedResults;
    }

}
