package test;

import manager.Manager;
import org.junit.jupiter.api.Test;
import utils.Task;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ManagerTest {
    @Test
    public void newTaskCanBeAdded() {
        Manager toDoList = new Manager();
        Task task = new Task();
        task.setTitle("Homework");
        task.setProductName("School");

        final int initialSize = toDoList.getTasks().size();

        toDoList.addToDo(task);

        assertEquals(initialSize + 1, toDoList.getTasks().size());
    }

    @Test
    public void removeTaskThrowsIndexOutOfBounds() {
        Manager list = new Manager();

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(list.getTasks().size()));
    }

    @Test
    public void FirstTaskCanBeRemoved() {
        Manager toDoList = new Manager();

        Task task = new Task();
        task.setTitle("Homework");
        task.setProductName("School");
        toDoList.addToDo(task);

        final int initialSize = toDoList.getTasks().size();

        toDoList.remove(0);

        assertEquals(initialSize - 1, toDoList.getTasks().size());
    }

    @Test
    public void FirstTaskCanBeRetrievedFromList() {
        Manager toDoList = new Manager();

        Task task = new Task();
        task.setTitle("Homework");
        task.setProductName("School");
        toDoList.addToDo(task);

        final Task retrievedFirstTask = toDoList.getTaskInToDo(0);

        assertEquals(retrievedFirstTask, task);
    }

    @Test
    public void ListCanBeRetrieved() {
        List<Task> list = new ArrayList<Task>();
        Manager toDoList = new Manager();

        toDoList.setTasks(list);

        final List<Task> retrievedList = toDoList.getTasks();

        assertEquals(retrievedList, list);
    }

}
