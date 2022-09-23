package admin;

import utils.Status;
import utils.Task;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Admin extends AdminMenu{

    private List<Task> taskList;
    private SimpleDateFormat simpleDateFormat;
    public Admin(List<Task> listOfToDos) {
        this.taskList = listOfToDos;
        this.simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
    }
    public void printEntireList() {
        printHeading();

        taskList.forEach(this::printBody);
    }

    public void printTasksByStatus(Status status) {
        printHeading();

        taskList.stream()
                .filter(task -> task.getStatus() == status)
                .forEach(this::printBody);

    }
    public void printTasksByProduct() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Select a Product below, by typing its name:");

        printIndexAndNameAndProductOfTask();
        String product = reader.nextLine().toLowerCase().trim();

        printHeading();

        taskList.stream()
                .filter(task -> task.getProductName().toLowerCase().trim().equals(product))
                .forEach(this::printBody);

    }
    public void printBody(Task task) {

        System.out.print(taskList.indexOf(task) + 1 + ". ");
        System.out.print(String.format("%1$-25s", task.getTitle()));
        System.out.print(String.format("%1$-25s", task.getProductName()));
        System.out.print(String.format("%1$-28s", task.getStatus()));
        System.out.print(String.format("%1$-25s", simpleDateFormat.format(task.getCreatedDate())));
        System.out.print(String.format("%1$-25s", simpleDateFormat.format(task.getExpireDate())));
        System.out.println("");
    }
    public void printTaskByExpireDate() {
        printHeading();
        taskList.sort(Comparator.comparing(Task::getExpireDate));
        taskList.stream().forEach(this::printBody);
    }
    public void printOnlyIndexAndNameOfTask() {
        for (Task list : taskList) {
            System.out.print(taskList.indexOf(list) + 1 + ". ");
            System.out.println(String.format("%1$-25s", list.getTitle()));
        }
    }
    public void printIndexAndNameAndProductOfTask() {
        for (Task list : taskList) {
            System.out.print(taskList.indexOf(list) + 1 + ". ");
            System.out.print(String.format("%1$-25s", list.getTitle()));
            System.out.print(String.format("%1$-25s", list.getProductName()));
            System.out.println();
        }
    }
    public void printIndexAndNameAndExpireDateOfTask() {
        for (Task list : taskList) {
            System.out.print(taskList.indexOf(list) + 1 + ". ");
            System.out.print(String.format("%1$-25s", list.getTitle()));
            System.out.print(String.format("%1$-25s", simpleDateFormat.format(list.getExpireDate())));
            System.out.println();
        }
    }
    public void printWelcome() {

        System.out.println("\n Welcome to MiNet’s Warehouse Management System! ");
        System.out.println(" Pending tasks: " + getBackAmount(Status.PENDING) + " | Completed tasks: " + getBackAmount(Status.SOLD));
        System.out.println("\n Pick an option:");
    }
    public int getBackAmount(Status status){
        int counter = 0;

        for(Task list: taskList){
            if(list.getStatus()== status){
                counter++;
            }
        }
        return counter;
    }

}
