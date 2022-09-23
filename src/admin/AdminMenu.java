package admin;

public class AdminMenu extends AdminMenuPrint{

    public static void printHeading() {
        System.out.println("Welcome to MiNet’s Warehouse ,here you can see all your products that you have manually add.");
        System.out.println();
        System.out.print(String.format("%1$-27s", "TASK"));
        System.out.print(String.format("%1$-27s", "PRODUCT"));
        System.out.print(String.format("%1$-27s", "STATUS"));
        System.out.print(String.format("%1$-27s", "DATE CREATED"));
        System.out.println("EXPIRE DATE");
        System.out.println("--------------------------------" +
                "--------------------------------------------" +
                "----------------------------------------");
    }
    public void printWhenQuitApplication() {
        System.out.println("You have quit the application, your Products are saved.");
    }

    public void printIndexOutOfReach() {
        System.out.println("Task with selected index does not exist. Select number in front of task again:");
    }
}
