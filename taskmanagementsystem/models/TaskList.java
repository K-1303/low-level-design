package taskmanagementsystem.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskList {
    private final String id;
    private List<Task> tasks;
    private final String name;

    public TaskList(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.tasks = new CopyOnWriteArrayList<>();
    }

     public void display() {
        System.out.println("--- Task List: " + name + " ---");
        for (Task task : tasks) {
            task.display("");
        }
        System.out.println("-----------------------------------");
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks); // Return a copy to prevent external modification
    }

    public void addTask(Task task) {
        tasks.add(task);
    }


    // Getters...
    public String getId() { return id; }
    public String getName() { return name; }
}