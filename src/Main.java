import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.Scanner;

import db.JDBC;

public class Main {
    public static void main(String[] args) throws Exception {

//        Connection con = JDBC.getInstance();


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

                Person admin = new Admin(CNP, name, dateOfBirth, phoneNumber, email, username1, password1);
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