package ChainOfResponsibilityDemo.demo_1;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class LogAppender {
    private final LogLevel minLogLevel;

    public void append(LogLevel level, String message) {
        if(level.compareTo(minLogLevel)>=0) {
            try {
                doAppend(message);
            } catch (Exception e) {
                System.err.println(e.getMessage()); 
            }
        }
    }

    protected abstract void doAppend(String message) throws Exception;
} 
