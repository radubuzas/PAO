import java.util.List;
import java.util.Map;
import java.util.Scanner;

//import from all the classes
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the School Management System!");
        System.out.println("Please choose an option:");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("Please enter your username:");
                String username = scanner.next();
                System.out.println("Please enter your password:");
                String password = scanner.next();
                //check if the username and password are correct
                //if they are correct, then go to the next menu
                //if they are not correct, then go back to the first menu
                break;
            case 2:
                System.out.println("Please enter your name:");
                String name = scanner.next();
                System.out.println("Please enter your CNP:");
                String CNP = scanner.next();
                System.out.println("Please enter your date of birth:");
                int dateOfBirth = scanner.nextInt();
                System.out.println("Please enter your phone number:");
                String phoneNumber = scanner.next();
                System.out.println("Please enter your email:");
                String email = scanner.next();
                System.out.println("Please enter your username:");
                String username1 = scanner.next();
                System.out.println("Please enter your password:");
                String password1 = scanner.next();
                //check if the username is already taken
                //if it is taken, then go back to the first menu
                //if it is not taken, then go to the next menu
                break;
            case 3:
                System.out.println("Thank you for using the School Management System!");
                break;
            default:
                System.out.println("Invalid option!");
                break;
        }
    }
}