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

    /**
     * Test 구조
     * <p>
     * before() -> runTestCase() -> after()
     * </p>
     */
    public void run() {
        before();
        runTestCase();
        after();
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
