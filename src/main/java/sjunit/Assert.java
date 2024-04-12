package sjunit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sjunit.error.AssertionFailedError;

/**
 * JUnit - Assert Class 와 같은 동작을 하는 클래스입니다.
 */
public class Assert {

    private static final Logger logger = LoggerFactory.getLogger(Assert.class);

    private Assert() {
    }

    public static void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionFailedError();
        }

        logger.info("Test Passed.");
    }
}
