package cashier;

import admin.Admin;
import manager.Manager;
import utils.FileHandler;
import utils.Status;
import utils.Task;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Cashier {
    private Scanner reader;
    private Manager manager;
    private FileHandler fileSave;
    private Admin printer;
    private SimpleDateFormat simpleDateFormat;

    public Cashier() throws IOException, ClassNotFoundException {
        reader = new Scanner(System.in);
        manager = new Manager();
        fileSave = new FileHandler();
        simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");

        FileHandler fileHandler = new FileHandler();
        manager.setTasks(fileHandler.loadFromFile());
        printer = new Admin(manager.getTasks());
    }
    public String userInput() {
        return reader.nextLine();
    }

    public void start() throws IOException, ClassNotFoundException {
        printer.printWelcome();
        response();
    }
    public void response() {
        while (true) {
            printer.printOptions();

            switch (userInput()) {
                case "1":
                    orderListOptions();
                    break;
                case "2":
                    addTask();
                    break;
                case "3":
                    editTask();
                    break;
                case "4":
                    quitAndSave();
                    return;
                default:
                    printer.printNotValiableOption();
            }
            printer.printPressEnterForMenu();
            userInput();
        }

    }

    public void addTask() {
        System.out.println("Add New Task \n");
        System.out.println("Name of Task:");

        Task task = new Task();
        task.setTitle(userInput());
        System.out.println("Name of Product");
        task.setProductName(userInput());
        System.out.println("Expire date? (MM-dd-yyyy)");

        while (true) {
            try {
                task.setExpireDate(simpleDateFormat.parse(userInput()));
                break;
            } catch (ParseException e) {
                printer.printWrongDateFormat();
            }
        }

        Date date = new Date();
        String strDate = simpleDateFormat.format(date);
        try {
            task.setCreatedDate(simpleDateFormat.parse(strDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        manager.addToDo(task);
        System.out.println("Task: " + task.getTitle() + " was added");
    }
    public void quitAndSave() {
        printer.printWhenQuitApplication();
        try {
            fileSave.saveToFile(manager.getTasks());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getTaskNumberAndChangeItToSold() {

        System.out.println("What task do you want to mark as sold? \n ");
        printer.printOnlyIndexAndNameOfTask();
        System.out.println("\n Enter the number in front of the task that you want to mark SOLD (0 -> return to Menu)");
        Task searched;

        while (true) {
            try {
                int getTaskByNumber = Integer.parseInt(userInput());

                if (getTaskByNumber != 0) {
                    searched = manager.getTaskInToDo(getTaskByNumber - 1);
                    break;
                } else {
                    response();
                }

            } catch (Exception e) {
                printer.printIndexOutOfReach();
            }
        }

        searched.setStatus(Status.SOLD);
        System.out.println("Task is now set to SOLD");
    }
    public void removeTask() {
        System.out.println("What of the below products do you want to delete? \n");
        printer.printOnlyIndexAndNameOfTask();
        System.out.println("\n Enter the number in front of the task you would like to delete (0 -> return to Menu)");

        while (true) {
            try {
                int removeProductByNumber = Integer.parseInt(userInput());
                if (removeProductByNumber != 0) {
                    manager.remove(removeProductByNumber - 1);
                    break;
                } else {
                    response();
                }
            } catch (Exception e) {
                printer.printIndexOutOfReach();
            }
        }

        System.out.println("Task is removed");

    }

    public void update() {
        printer.printUpdateOptions();
        switch (userInput()) {
            case "0":
                response();
                break;
            case "1":
                editName();
                break;
            case "2":
                editProduct();
                break;
            case "3":
                editDate();
                break;
            default:
                printer.printNotValiableOption();
                update();
        }
    }
    public void editName() {
        System.out.println("Here you can edit a name for one of your tasks:\n ");
        printer.printOnlyIndexAndNameOfTask();
        System.out.println("\n Enter the number in front of the task which name you want to switch (0 -> Return to Menu)");
        Task searched;

        while (true) {
            try {
                int getTitleByNumber = Integer.parseInt(userInput());

                if (getTitleByNumber != 0) {
                    searched = manager.getTaskInToDo(getTitleByNumber - 1);
                    break;
                } else {
                    response();
                }
            } catch (Exception e) {
                printer.printIndexOutOfReach();
            }
        }

        System.out.println("What do you want to switch the name of " + searched.getTitle() + " to?");
        String newName = userInput();
        searched.setTitle(newName);
        System.out.println("Name edited to " + newName);
    }

    public void editProduct() {
        System.out.println("Here you can edit a name of a product that your task is assigned to\n ");
        printer.printIndexAndNameAndProductOfTask();
        System.out.println("\n Enter the number in front of the task you want to switch the product to (0 -> Return to Menu) ");
        Task searched;

        while (true) {
            try {
                int getProductByNumber = Integer.parseInt(userInput());

                if(getProductByNumber != 0){
                    searched = manager.getTaskInToDo(getProductByNumber - 1);
                    break;
                }
                else{
                    response();
                }

            } catch (Exception e) {
                printer.printIndexOutOfReach();
            }
        }

        System.out.println("What product should " + searched.getTitle() + " belong to?");
        String newProject = userInput();
        searched.setProductName(newProject);
        System.out.println(searched.getTitle() + " now belongs to product: " + newProject);
    }
    public void editDate() {
        System.out.println("Here you can edit expire date of one of below tasks: \n ");
        printer.printIndexAndNameAndExpireDateOfTask();
        System.out.println("\n Enter the number in front of the task you want to switch expire date (0 -> Return to Menu)");

        try {
            int getProductByNumber = Integer.parseInt(userInput());

            if(getProductByNumber != 0){
                Task searched = manager.getTaskInToDo(getProductByNumber - 1);
                System.out.println("Enter new expire date of task " + searched.getTitle() + " below (MM-dd-yyyy)");

                while (true) {
                    try {
                        searched.setExpireDate(simpleDateFormat.parse(userInput()));
                        break;
                    } catch (ParseException e) {
                        printer.printWrongDateFormat();
                    }
                }
                System.out.println(searched.getTitle() + " Expire Date is set to " + simpleDateFormat.format(searched.getExpireDate()));}
            else{
                response();
            }
        } catch (NumberFormatException e) {
            printer.printIndexOutOfReach();
            editDate();
        }
    }

    public void editTask() {
        printer.printEditTaskOptions();

        switch (userInput()) {
            case "0":
                response();
                break;
            case "1":
                removeTask();
                break;
            case "2":
                getTaskNumberAndChangeItToSold();
                break;
            case "3":
                update();
                break;
            default:
                printer.printNotValiableOption();
                editTask();
        }
    }
    public void orderListOptions() {
        printer.printSortingOptions();

        switch (userInput()) {
            case "0":
                response();
                break;
            case "1":
                printer.printEntireList();
                break;
            case "2":
                printer.printTasksByStatus(Status.PENDING);
                break;
            case "3":
                printer.printTasksByStatus(Status.SOLD);
                break;
            case "4":
                printer.printTasksByProduct();
                break;
            case "5":
                printer.printTaskByExpireDate();
                break;
            default:
                printer.printNotValiableOption();
                orderListOptions();
        }
    }
}
