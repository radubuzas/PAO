package db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import scripts.ScriptRunner;

public class JDBC{

    private static final String db = "test010111111111";
    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String uname = "root";
    private static final String pass = "radu2002";
    private static Connection con = null;

    public static Connection getInstance() throws Exception{
        if (con == null) {                      //  load DB driver
            try {
                Class.forName ("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException error) {
                System.out.println("Unable to load the MySQL JDBC driver: " + error.getMessage());
                System.exit(123);
            }

            try {                               //  connect to DB
                con = DriverManager.getConnection(url, uname, pass);
                if (con != null)
                    System.out.println("Connection successful!");
                else
                    System.out.println("Connection failed!");
            }
            catch (SQLException error) {
                System.out.println("Unable to create a connection: " + error.getMessage());
            }

            try {
                boolean dbExists = false;
                ResultSet resultSet = con.getMetaData().getCatalogs();
                String databaseName = "";
                while (resultSet.next()) {
                    // Get the database name, which is at position 1
                    databaseName = resultSet.getString(1);
                    System.out.println(databaseName);
                    if (databaseName.compareTo(db) == 0) {
                        dbExists = true;
                        System.out.println("Database " + db + " already exists.");
                        break;
                    }
                }
                if (!dbExists) {
                    System.out.println("Database " + db + " does not exist.");
                    selectDB();
                    createTables();
                }
            }
            catch (SQLException error) {
                System.out.println("Unable to check if database exists: " + error.getMessage());
            }

        }

        return con;
    }

    private static void selectDB() throws Exception {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + db);
            stmt.executeUpdate("USE " + db);
        }
        catch (SQLException error) {
            System.out.println("Unable to create a database: " + error.getMessage());
        }
    }

    private static void createTables() throws Exception {
        String fileName = "src/db/create-tables.sql";
        ScriptRunner scriptRunner = new ScriptRunner(con, false, false);
        try {
            scriptRunner.runScript(new BufferedReader(new FileReader(fileName)));
        } catch (Exception error) {
            System.out.println("Error reading SQL file: " + error.getMessage());
            System.exit(123);
        }
//        try (Statement statement = con.createStatement()) {
//            System.out.println("Executing SQL commands: " + sqlCommands);
//            boolean executeResult = statement.execute(sqlCommands);
//            if (!executeResult) {
//                System.out.println("Tables created successfully.");
//            } else {
//                System.out.println("Failed to create tables.");
//            }
//        } catch (SQLException error) {
//            System.out.println("Error executing SQL commands: " + error.getMessage());
//            System.exit(123);
//        }
    }
}