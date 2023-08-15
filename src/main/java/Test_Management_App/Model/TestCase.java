package Test_Management_App.Model;

import javax.persistence.*;

@Entity
@Table(name = "test_case")
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTestCase;
    @Column(name = "signature")
    private String signature;
    @Column(name = "test_case_name")
    private String testCaseName;
    @Column(name = "preconditions")
    private String preconditions;
    @Column(name = "description")
    private String description;

    public TestCase(){
    }

    public int getId() {
        return idTestCase;
    }

    public void setId(int id) {
        this.idTestCase = id;
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

    @Column(name = "expected_results")
    private String expectedResults;
}
