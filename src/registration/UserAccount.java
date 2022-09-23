package registration;


public class UserAccount extends Register {
    public UserAccount() {
        try {
            System.out.println("Welcome to MiNet’s Warehouse Management System\n");
            System.out.println("========Main Menu options===========");
            System.out.println("1. Create user account");
            System.out.println("2. Login user account");
            System.out.println("Enter choice : ");
            String choice = scanner.nextLine();
            if (choice.equals("1")){
                createaccount();
            } else if (choice.equals("2")){
                Login();
            } else {
                System.out.println("Invalid choice");
                System.out.println("Press any key to continue ....");
                String proceed = scanner.nextLine();
                new UserAccount();
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());

        }
    }
}
