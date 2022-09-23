package manager;

import utils.Task;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private List<Task> tasks = new ArrayList<>();

    public void addToDo(Task task) { tasks.add(task);}

    public void remove(int index) {
        tasks.remove(index);
    }

    public void setTasks(List<Task> newTasks) {
        tasks = newTasks;
    }


    public List<Task> getTasks() {
        return tasks;
    }


    public Task getTaskInToDo(int index) {
        return tasks.get(index);
    }
}
