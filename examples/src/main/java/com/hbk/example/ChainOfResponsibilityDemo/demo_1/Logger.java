package com.hbk.example.ChainOfResponsibilityDemo.demo_1;

import java.util.List;
import java.util.Arrays;

public  class Logger {
    private final List<LogAppender> appenderList;

    public Logger(LogAppender... appenderList) {
        this.appenderList=Arrays.asList(appenderList);
    } 

    public void info(String message) {
        log(LogLevel.LEVEL_INFO, message);
    }

    public void error(String message) {
        log(LogLevel.LEVEL_ERROR, message);
    }

    public void log(LogLevel level, String message) {
        appenderList.forEach(
            appender->appender.append(level, message)
        );
    }
}
