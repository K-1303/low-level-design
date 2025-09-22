package taskmanagementsystem.observer;

import taskmanagementsystem.models.Task;

public interface TaskObserver {
    public void update(Task task, String changeType);
}