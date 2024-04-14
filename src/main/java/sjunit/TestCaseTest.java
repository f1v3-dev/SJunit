package sjunit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sjunit.assertion.Assert;
import sjunit.domain.TestResult;

public class TestCaseTest extends TestCase {

    private static final Logger logger = LoggerFactory.getLogger(TestCaseTest.class);

    private static long base;

    @Override
    public void before() {
        this.base = 10L;
    }

    public TestCaseTest(String testCaseName) {
        super(testCaseName);
    }


    public void runTest() {
        long sum = 10 + base;
        Assert.assertTrue(sum == 20);
    }

    public void runTestMinus() {
        long minus = 100 - base;
        Assert.assertTrue(minus == 80);
    }

    /**
     * TestCaseTest Instance를 new로 생성하는 이유
     * <p>
     * - 각각의 테스트가 독립적으로 실행하기 위해서는 새로운 인스턴스에서 수행되어야 한다.
     * </p>
     */
    public static void main(String[] args) {

        TestResult testResult = new TestResult();
        new TestCaseTest("runTest").run(testResult);
        new TestCaseTest("runTestMinus").run(testResult);

        testResult.printCount();
    }
}
