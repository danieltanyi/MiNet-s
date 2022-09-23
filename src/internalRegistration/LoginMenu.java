package internalRegistration;

import cashier.Cashier;
import registration.UserAccount;

import java.io.IOException;
import java.util.Scanner;

public class LoginMenu {
    public LoginMenu() {
    }

    public static void showManager() throws IOException, ClassNotFoundException {
        System.out.println("Welcome Manager" );
       // new UserAccount();
        LoginMenuLogic.login();
        Cashier display = new Cashier();
        display.start();
        // do something
    }

    public static void showCashier() throws IOException, ClassNotFoundException {
        System.out.println("Welcome Cashier");
        LoginMenuLogic.login();
       // new UserAccount();
        // do something
    }

    public static void showAdmin() throws IOException, ClassNotFoundException {
        System.out.println("Welcome Admin");
        LoginMenuLogic.login();
       // new UserAccount();
        Cashier display = new Cashier();
        display.start();
        //do something
    }
}
