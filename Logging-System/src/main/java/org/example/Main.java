package org.example;

import org.example.chain.DebugLogger;
import org.example.chain.ErrorLogger;
import org.example.chain.InfoLogger;
import org.example.chain.LogHandler;
import org.example.entity.Logger;
import org.example.entity.LoggerConfig;
import org.example.enums.LogLevel;
import org.example.strategy.ConsoleAppender;
import org.example.strategy.FileAppender;
import org.example.strategy.LogAppender;

public class Main {
    // Build the chain of loggers: INFO -> DEBUG -> ERROR
    private static LogHandler getChainOfLoggers(LogAppender appender) {
        LogHandler errorLogger = new ErrorLogger(LogHandler.ERROR, appender);
        LogHandler debugLogger = new DebugLogger(LogHandler.DEBUG, appender);
        LogHandler infoLogger = new InfoLogger(LogHandler.INFO, appender);
        infoLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(errorLogger);
        return infoLogger;
    }

    public static void main(String[] args) {
        // Select the log appender (console or file)
        LogAppender consoleAppender = new ConsoleAppender();
        LogAppender fileAppender = new FileAppender("logs.txt");
        // Create the chain of loggers with the console appender
        LogHandler loggerChain = getChainOfLoggers(consoleAppender);

        // Use a single logging approach to avoid duplication
        System.out.println("Logging INFO level message:");
        loggerChain.logMessage(LogHandler.INFO, "This is an information.");
        System.out.println("nLogging DEBUG level message:");
        loggerChain.logMessage(LogHandler.DEBUG, "This is a debug level information.");
        System.out.println("nLogging ERROR level message:");
        loggerChain.logMessage(LogHandler.ERROR, "This is an error information.");

        // Demonstrate the singleton Logger usage as an alternative
        System.out.println("nUsing Singleton Logger:");
        Logger logger = Logger.getInstance(LogLevel.INFO, consoleAppender);
        logger.setConfig(new LoggerConfig(LogLevel.INFO, fileAppender));
        logger.error("Using singleton Logger - Error message");
    }
}
