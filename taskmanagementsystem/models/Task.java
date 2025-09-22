package taskmanagementsystem.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import taskmanagementsystem.enums.TaskPriority;
import taskmanagementsystem.enums.TaskStatus;
import taskmanagementsystem.observer.TaskObserver;
import taskmanagementsystem.state.TaskState;
import taskmanagementsystem.state.TodoState;

public class Task {
    private final String id;
    private final List<Task> subtasks;
    private TaskState currentState;
    private final List<ActivityLog> activityLogs;
    private final Set<Tag> tags;
    private String description;
    private final List<TaskObserver> observers;
    private final User createdBy;
    private LocalDate dueDate;
    private User assignee;
    private final List<Comment> comments;
    private String title;
    private TaskPriority priority;

    private Task(TaskBuilder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.dueDate = builder.dueDate;
        this.priority = builder.priority;
        this.createdBy = builder.createdBy;
        this.assignee = builder.assignee;
        this.tags = builder.tags;
        this.currentState = new TodoState(); // Initial state
        this.comments = new ArrayList<>();
        this.subtasks = new ArrayList<>();
        this.activityLogs = new ArrayList<>();
        this.observers = new ArrayList<>();
        addLog("Task created with title: " + title);
    }

    public synchronized void setAssignee(User user) {
        this.assignee = user;
        addLog("Assignee set to: " + user.getName());
        notifyObservers("Assignee");
    }

    public synchronized void updatePriority(TaskPriority priority) {
        this.priority = priority;
        notifyObservers("priority");
    }

    public synchronized void addComment(Comment comment) {
        comments.add(comment);
        addLog("Comment added by " + comment.getAuthor().getName());
        notifyObservers("comment");
    }

    public synchronized void addSubtask(Task subtask) {
        subtasks.add(subtask);
        addLog("Subtask added: " + subtask.getTitle());
        notifyObservers("subtask_added");
    }

    // --- State Pattern Methods ---
    public void setState(TaskState state) {
        this.currentState = state;
        addLog("Status changed to: " + state.getStatus());
        notifyObservers("status");
    }
    public void startProgress() { currentState.startProgress(this); }
    public void completeTask() { currentState.completeTask(this); }
    public void reopenTask() { currentState.reopenTask(this); }

    // --- Observer Pattern Methods ---
    public void addObserver(TaskObserver observer) { observers.add(observer); }
    public void removeObserver(TaskObserver observer) { observers.remove(observer); }
    public void notifyObservers(String changeType) {
        for (TaskObserver observer : observers) {
            observer.update(this, changeType);
        }
    }
    public void addLog(String logDescription) {
        this.activityLogs.add(new ActivityLog(logDescription));
    }

    public boolean isComposite() { return !subtasks.isEmpty(); }

    public void display(String indent) {
        System.out.println(indent + "- " + title + " [" + getStatus() + ", " + priority + ", Due: " + dueDate + "]");
        if (isComposite()) {
            for (Task subtask : subtasks) {
                subtask.display(indent + "  ");
            }
        }
    }

    // Getters and setters
    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public TaskPriority getPriority() {
        return priority;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public User getAssignee() {
        return assignee;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return currentState.getStatus();
    }

    public static class TaskBuilder {
        private final String id;
        private String title;
        private String description = "";
        private LocalDate dueDate;
        private TaskPriority priority;
        private User createdBy;
        private User assignee;
        private Set<Tag> tags;

        public TaskBuilder(String title) {
            this.id = UUID.randomUUID().toString();
            this.title = title;
        }

        public TaskBuilder description(String description) { this.description = description; return this; }
        public TaskBuilder dueDate(LocalDate dueDate) { this.dueDate = dueDate; return this; }
        public TaskBuilder priority(TaskPriority priority) { this.priority = priority; return this; }
        public TaskBuilder assignee(User assignee) { this.assignee = assignee; return this; }
        public TaskBuilder createdBy(User createdBy) { this.createdBy = createdBy; return this; }
        public TaskBuilder tags(Set<Tag> tags) { this.tags = tags; return this; }

        public Task build() {
            return new Task(this);
        }
    }
}