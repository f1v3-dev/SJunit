package sjunit;

public abstract class TestCase {

    protected String testCaseName;

    protected TestCase(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public abstract void run();
}
