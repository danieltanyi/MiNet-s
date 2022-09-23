package admin;

public class AdminMenuPrint {
    public void printOptions() {
        System.out.println("---------------------------------------------");
        System.out.println(" (1) Show Task List:");
        System.out.println(" (2) Add New Task");
        System.out.println(" (3) Edit Task (remove, mark as sold, update)");
        System.out.println(" (4) Save and Quit");
    }
    public void printNotValiableOption() {
        System.out.println("You have not entered a viable option. Let's try this again. \n");
    }

    public void printWrongDateFormat() {
        System.out.println("Input of date was in wrong format. REQUIRED FORMAT: (MM-dd-yyyy)");
    }

    public void printUpdateOptions() {
        System.out.println("Press (1) for editing task name");
        System.out.println("Press (2) for editing product name of a specific task");
        System.out.println("Press (3) for editing expire date of a task");
    }
    public void printEditTaskOptions() {
        System.out.println("Press (1) for removing items from the list");
        System.out.println("Press (2) for marking tasks as sold");
        System.out.println("Press (3) for updating tasks");
    }

    public void printSortingOptions() {
        System.out.println("Here you can print list sorted by:");
        System.out.println("(1): Show all");
        System.out.println("(2): All tasks that are PENDING");
        System.out.println("(3): All tasks that are SOLD");
        System.out.println("(4): Print task by PRODUCT:");
        System.out.println("(5): Expire Date");
    }
    public void printPressEnterForMenu() {
        System.out.println("\n Press ENTER to see options again");
    }
}
