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
        LoginMenuLogic.login();
        Cashier display = new Cashier();
        display.start();
    }

    public static void showCashier() throws IOException, ClassNotFoundException {
        System.out.println("Welcome Cashier");
        LoginMenuLogic.login();
    }

    public static void showAdmin() throws IOException, ClassNotFoundException {
        System.out.println("Welcome Admin");
        LoginMenuLogic.login();
        Cashier display = new Cashier();
        display.start();

    }
}
