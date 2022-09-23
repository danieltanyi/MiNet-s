package registration;

import internalRegistration.LoginMenuLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Login {
    Scanner scanner = new Scanner(System.in);
    String filename = "login.txt";

    void Login() throws IOException {
        try {
            Path path = Paths.get(filename.toString());
            InputStream input = Files.newInputStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            System.out.println("\nL O G I N\n ");
            System.out.print("Enter username ");
            String username = scanner.nextLine();
            System.out.print("Enter password ");
            String password = scanner.nextLine();
            String temporary = null;
            String userName;
            String passWord;
            boolean found = false;
            while ((temporary = reader.readLine()) != null) {
                String[] login = temporary.split(",");
                userName = login[0];
                passWord = login[1];
                if (userName.equals(username) && passWord.equals(password)) {
                    found = true;
                }
            }
            if (found == true) {
                LoginMenuLogic.login();

            } else {
                System.out.println("Access denied! Invalid username or password");
            }
            reader.close();
            System.out.println("Press any key to continue ....");
            String proceed = scanner.nextLine();
            new UserAccount();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
