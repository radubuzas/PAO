import db.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDL {
    private static Connection connection;

    public StudentDL() throws Exception {
        connection = JDBC.getInstance();
    }

    public void createStudent(Student student) {
        try {
            String query = "INSERT INTO Student (CNP, name, dateOfBirth, phoneNumber, email, username, password, grade, school, classGroup) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, student.getCNP());
            preparedStmt.setString(2, student.getName());
            preparedStmt.setInt(3, student.getDateOfBirth());
            preparedStmt.setString(4, student.getPhoneNumber());
            preparedStmt.setString(5, student.getEmail());
            preparedStmt.setString(6, student.getUsername());
            preparedStmt.setString(7, student.getPassword());
            preparedStmt.setInt(8, student.getGrade());
            preparedStmt.setString(9, student.getSchool());
            preparedStmt.setString(10, student.getClassGroup());
            preparedStmt.executeUpdate();
            preparedStmt.close();
        } catch (SQLException error) {
            System.out.println("Unable to create a new student: " + error.getMessage());
            System.exit(123);
        }
    }

    public void deleteStudent(String CNP) {
        try {
            String query = "DELETE FROM Student WHERE CNP = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, CNP);
            preparedStmt.executeUpdate();
            preparedStmt.close();
        } catch (SQLException error) {
            System.out.println("Unable to delete student: " + error.getMessage());
            System.exit(123);
        }
    }

    public Student getStudentByCNP(String CNP) {
        Student student = null;
        try {
            String query = "SELECT * FROM Student WHERE CNP = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, CNP);
            ResultSet resultSet = preparedStmt.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int dateOfBirth = resultSet.getInt("dateOfBirth");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                int grade = resultSet.getInt("grade");
                String school = resultSet.getString("school");
                String classGroup = resultSet.getString("classGroup");
                student = new Student(CNP, name, dateOfBirth, phoneNumber, email, username, password, grade, school, classGroup);
            }
            resultSet.close();
            preparedStmt.close();
        } catch (SQLException error) {
            System.out.println("Unable to get student: " + error.getMessage());
            System.exit(123);
        }
        return student;
    }
}

