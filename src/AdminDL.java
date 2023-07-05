import db.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDL {
    private static Connection connection;

    public AdminDL() throws Exception {
        connection = JDBC.getInstance();
    }

    public void createAdmin(Admin admin) {
        try {
            String query = "INSERT INTO Admin (username, password) VALUES (?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, admin.getUsername());
            preparedStmt.setString(2, admin.getPassword());
            preparedStmt.executeUpdate();
            preparedStmt.close();
        } catch (SQLException error) {
            System.out.println("Unable to create a new admin: " + error.getMessage());
        }
    }

    public void deleteAdmin(String username) {
        try {
            String query = "DELETE FROM Admin WHERE username = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, username);
            preparedStmt.executeUpdate();
            preparedStmt.close();
        } catch (SQLException error) {
            System.out.println("Unable to delete admin: " + error.getMessage());
        }
    }

    public Admin getAdminByUsername(String username) {
        Admin admin = null;
        try {
            String query = "SELECT * FROM Admin WHERE username = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, username);
            ResultSet resultSet = preparedStmt.executeQuery();
            if (resultSet.next()) {
                String password = resultSet.getString("password");
                admin = new Admin(username, password);
            }
            resultSet.close();
            preparedStmt.close();
        } catch (SQLException error) {
            System.out.println("Unable to get admin: " + error.getMessage());
        }
        return admin;
    }

    public List<Admin> getAllAdmins() {
        List<Admin> admins = new ArrayList<>();
        try {
            String query = "SELECT * FROM Admin";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            ResultSet resultSet = preparedStmt.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                Admin admin = new Admin(username, password);
                admins.add(admin);
            }
            resultSet.close();
            preparedStmt.close();
        } catch (SQLException e) {
            System.out.println("Unable to get all admins: " + e.getMessage());
        }
        return admins;
    }
}
