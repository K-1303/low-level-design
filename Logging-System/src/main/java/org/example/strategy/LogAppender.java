package org.example.strategy;

import org.example.entity.LogMessage;

public interface LogAppender {
    void append(LogMessage logMessage);
}
