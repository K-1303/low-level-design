package taskmanagementsystem.state;

import taskmanagementsystem.enums.TaskStatus;
import taskmanagementsystem.models.Task;

public interface TaskState {
    public void completeTask(Task task);
    public void reopenTask(Task task);
    public TaskStatus getStatus();
    public void startProgress(Task task);
}