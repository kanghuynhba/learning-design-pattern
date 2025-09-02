package ChainOfResponsibilityDemo.demo_1;

public class LogConsoleAppender extends LogAppender {
    public LogConsoleAppender(LogLevel minLogLevel) {
        super(minLogLevel);
    }

    @Override 
    protected void doAppend(String message) throws Exception {
        System.out.println(message);
    }
}
