package sjunit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sjunit.error.AssertionFailedError;

import java.lang.reflect.InvocationTargetException;
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

        try {
            runTestCase();
        } catch (InvocationTargetException ite) {
            if (isAssertionFailed(ite)) {
                testResult.addFailure(this);
            } else {
                testResult.addError(this, ite);
            }
        } catch (Exception e) {
            testResult.addError(this, e);
        } finally {
            after();
        }
    }

    /**
     * Method.invoke(...) 를 사용하였기 떄문에 InvocationTargetException
     */
    private boolean isAssertionFailed(InvocationTargetException ite) {
        return ite.getTargetException() instanceof AssertionFailedError;
    }

    private TestResult createTestResult() {
        return new TestResult();
    }

    protected void before() {
    }


    private void runTestCase() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        logger.info("{} execute", testCaseName);

        Method method = this.getClass().getMethod(testCaseName, null);
        method.invoke(this, null);
    }

    protected void after() {
    }


    public String getTestCaseName() {
        return this.testCaseName;
    }
}
