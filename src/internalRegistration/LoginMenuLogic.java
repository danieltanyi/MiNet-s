package internalRegistration;

import admin.AdminMenu;
import cashier.Cashier;

import java.io.IOException;
import java.util.Scanner;

public class LoginMenuLogic extends AdminMenu {
    public static void login() throws IOException, ClassNotFoundException {
        System.out.println("=================User Log Portal===============");
        System.out.println("Choose The Login choice you want to perform: ");
        System.out.println("[1] Administrator Log-In Portal: ");
        System.out.println("[2] Cashier Log-In Portal: ");
        System.out.println("[3] Manager Log-In Portal: ");
        Scanner scanner = new Scanner(System.in);

        int option = scanner.nextInt();
        scanner.nextLine();
        if(option == 1) {
            System.out.println("Welcome Admin");
            Cashier display = new Cashier();
            display.start();
            printHeading();
        }
        else if(option == 2) {
            System.out.println("Welcome Cashier");
            Cashier display = new Cashier();
            display.start();
        }
        else if(option == 3){
            System.out.println("Welcome Manager");
            Cashier display = new Cashier();
            display.start();
        }
    }
}
