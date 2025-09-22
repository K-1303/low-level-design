package taskmanagementsystem.models;

import java.time.LocalDateTime;

public class ActivityLog {
    private final LocalDateTime timestamp;
    private final String description;

    public ActivityLog(String description) {
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + description;
    }
}