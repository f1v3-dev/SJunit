package sjunit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 테스트 결과를 출력하기 위한 클래스.
 * <p>
 * Collecting Parameter Pattern 적용
 */
public class TestResult {

    private static final Logger logger = LoggerFactory.getLogger(TestResult.class);

    private int runTestCount;

    public TestResult() {
        this.runTestCount = 0;
    }

    /**
     * synchronized : 하나의 TestResult 인스턴스를 여러 테스트 케이스에서 사용하게 될 경우
     * 스레드 동기화 문제 발생 !! -> 간단하게 synchronized 로 해결
     * (테스트 케이스에서만 사용하기 때문에 성능 이슈를 고려하지 않아도 된다.)
     */
    public synchronized void startTest() {
        this.runTestCount++;
    }

    public void printCount() {
        logger.info("Total Test Count: {}", runTestCount);
    }
}
