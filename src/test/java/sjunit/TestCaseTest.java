package sjunit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class TestCaseTest extends TestCase {

    private static final Logger logger = LoggerFactory.getLogger(TestCaseTest.class);

    public TestCaseTest(String testCaseName) {
        super(testCaseName);
    }

    @Override
    public void run() {

        try {
            logger.info("{} execute ", testCaseName);
            Method method = this.getClass().getMethod(super.testCaseName, null);
            method.invoke(this, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void runTest() {
        long sum = 10 + 10;
        Assert.assertTrue(sum == 20);
    }

    public void runTestMinus() {
        long minus = 100 - 10;
        Assert.assertTrue(minus == 90);
    }

    /**
     * TestCaseTest Instance를 new로 생성하는 이유
     * <p>
     * - 각각의 테스트가 독립적으로 실행하기 위해서는 새로운 인스턴스에서 수행되어야 한다.
     * </p>
     */
    public static void main(String[] args) {

        new TestCaseTest("runTest").run();
        new TestCaseTest("runTestMinus").run();
    }
}
