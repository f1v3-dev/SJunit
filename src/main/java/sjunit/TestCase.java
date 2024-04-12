package sjunit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public abstract class TestCase {

    private static final Logger logger = LoggerFactory.getLogger(TestCase.class);


    protected String testCaseName;

    protected TestCase(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public TestResult test() {
        TestResult testResult = createTestResult();
        run(testResult);

        return testResult;
    }

    /**
     * Test 구조
     * <p>
     * before() -> runTestCase() -> after()
     * </p>
     */
    public void run(TestResult testResult) {
        testResult.startTest();
        before();
        runTestCase();
        after();
    }

    private TestResult createTestResult() {
        return new TestResult();
    }

    protected void before() {
    }

    private void runTestCase() {
        try {
            logger.info("{} execute", testCaseName);

            Method method = this.getClass().getMethod(testCaseName, null);
            method.invoke(this, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void after() {
    }
}
