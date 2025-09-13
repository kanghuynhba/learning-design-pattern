package com.hbk.example.ChainOfResponsibilityDemo.demo_1;

public class ChainOfResponsibility {
    public static void main(String []args) {
        final Logger logger=new Logger(
            new LogConsoleAppender(LogLevel.LEVEL_INFO),
            new LogFileAppender(LogLevel.LEVEL_ERROR)
        );    

        logger.info("Hello World");
        logger.error("Foo Bar");
    }
}
