package registration;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.CREATE;

public class Register extends Login {
    protected void createaccount() {
        try {
            Path path = Paths.get(filename.toString());
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(path, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            System.out.println("\nR E G I S T E R\n ");
            System.out.print("Enter username : ");
            String username = scanner.nextLine();
            System.out.print("Enter password : ");
            String password = scanner.nextLine();

            writer.write(username + "," + password);
            writer.newLine();
            System.out.println("Account has been successfully saved");
            writer.close();
            output.close();

            System.out.println("Press any key to continue ....");
            String proceed = scanner.nextLine();

            new UserAccount();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }
}
