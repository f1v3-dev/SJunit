package sjunit.domain;

import sjunit.TestCase;

public class TestFailure {

    private TestCase testCase;

    public TestFailure(TestCase testCase) {
        this.testCase = testCase;
    }

    public String getTestCaseName() {
        return this.testCase.getTestCaseName();
    }
}