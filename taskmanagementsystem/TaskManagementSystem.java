package taskmanagementsystem;

import taskmanagementsystem.models.User;
import java.util.Map;
import taskmanagementsystem.models.TaskList;
import taskmanagementsystem.models.Task;
import java.util.concurrent.ConcurrentHashMap;
import java.time.LocalDate;
import taskmanagementsystem.enums.TaskPriority;
import taskmanagementsystem.observer.ActivityLogger;
import java.util.List;
import java.util.stream.Collectors;
import taskmanagementsystem.enums.TaskStatus;
import taskmanagementsystem.strategy.TaskSortStrategy;
import java.util.ArrayList;

public class TaskManagementSystem {
    private final Map<String, User> users;
    private static TaskManagementSystem instance;
    private final Map<String, TaskList> taskLists;
    private final Map<String, Task> tasks;

    private TaskManagementSystem() {
        users = new ConcurrentHashMap<>();
        tasks = new ConcurrentHashMap<>();
        taskLists = new ConcurrentHashMap<>();
    }

    public static synchronized TaskManagementSystem getInstance() {
        if (instance == null) {
            instance = new TaskManagementSystem();
        }
        return instance;
    }

    public User createUser(String name, String email) {
        User user = new User(name, email);
        users.put(user.getId(), user);
        return user;
    }

    public TaskList createTaskList(String listName) {
        TaskList taskList = new TaskList(listName);
        taskLists.put(taskList.getId(), taskList);
        return taskList;
    }

    public Task createTask(String title, String description, LocalDate dueDate,
                           TaskPriority priority, String createdByUserId) {
        User createdBy = users.get(createdByUserId);
        if (createdBy == null)
            throw new IllegalArgumentException("User not found.");

        Task task = new Task.TaskBuilder(title)
                .description(description)
                .dueDate(dueDate)
                .priority(priority)
                .createdBy(createdBy)
                .build();

        task.addObserver(new ActivityLogger());

        tasks.put(task.getId(), task);
        return task;
    }

    public List<Task> listTasksByUser(String userId) {
        User user = users.get(userId);
        return tasks.values().stream()
                .filter(task -> user.equals(task.getAssignee()))
                .toList();
    }

    public List<Task> listTasksByStatus(TaskStatus status) {
        return tasks.values().stream()
                .filter(task -> task.getStatus() == status)
                .collect(Collectors.toList());
    }

    public void deleteTask(String taskId) {
        tasks.remove(taskId);
    }

    public List<Task> searchTasks(String keyword, TaskSortStrategy sortingStrategy) {
        List<Task> matchingTasks = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getTitle().contains(keyword) || task.getDescription().contains(keyword)) {
                matchingTasks.add(task);
            }
        }
        sortingStrategy.sort(matchingTasks);
        return matchingTasks;
    }
}