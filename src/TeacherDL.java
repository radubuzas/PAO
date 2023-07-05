import db.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class TeacherDL {
    private static Connection connection;

    public TeacherDL() throws Exception {
        connection = JDBC.getInstance();
    }

    public void createTeacher(Teacher teacher) {
        try {
            String query = "INSERT INTO Teacher (CNP, name, dateOfBirth, phoneNumber, email, username, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, teacher.getCNP());
            preparedStmt.setString(2, teacher.getName());
            preparedStmt.setInt(3, teacher.getDateOfBirth());
            preparedStmt.setString(4, teacher.getPhoneNumber());
            preparedStmt.setString(5, teacher.getEmail());
            preparedStmt.setString(6, teacher.getUsername());
            preparedStmt.setString(7, teacher.getPassword());
            preparedStmt.executeUpdate();
            preparedStmt.close();
        } catch (SQLException error) {
            System.out.println("Unable to create a new teacher: " + error.getMessage());
            System.exit(123);
        }
    }

    public void deleteTeacher(String CNP) {
        try {
            String query = "DELETE FROM Teacher WHERE CNP = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, CNP);
            preparedStmt.executeUpdate();
            preparedStmt.close();
        } catch (SQLException error) {
            System.out.println("Unable to delete teacher: " + error.getMessage());
            System.exit(123);
        }
    }

    public Subject getSubjectById(int subjectId) {
        Subject subject = null;
        try {
            String query = "SELECT * FROM Subject WHERE id = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, subjectId);
            ResultSet resultSet = preparedStmt.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                subject = new Subject(subjectId, name);
            }
            resultSet.close();
            preparedStmt.close();
        } catch (SQLException error) {
            System.out.println("Unable to get subject by id: " + error.getMessage());
            System.exit(123);
        }
        return subject;
    }


    public Set<Subject> getTeacherSubjects(String CNP) {
        Set<Subject> subjects = new HashSet<>();
        try {
            String query = "SELECT * FROM Teacher_Subject WHERE teacher_CNP = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, CNP);
            ResultSet resultSet = preparedStmt.executeQuery();
            while (resultSet.next()) {
                int subjectId = resultSet.getInt("subject_id");
                Subject subject = getSubjectById(subjectId);
                if (subject != null) {
                    subjects.add(subject);
                }
            }
            resultSet.close();
            preparedStmt.close();
        } catch (SQLException error) {
            System.out.println("Unable to get teacher subjects: " + error.getMessage());
            System.exit(123);
        }
        return subjects;
    }


    public Teacher getTeacherByCNP(String CNP) {
        Teacher teacher = null;
        try {
            String query = "SELECT * FROM Teacher WHERE CNP = ?";
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
                Set<Subject> subjects = getTeacherSubjects(CNP);
                Set<String> classGroups = getTeacherClassGroups(CNP);
                teacher = new Teacher(CNP, name, dateOfBirth, phoneNumber, email, username, password, subjects, classGroups);
            }
            resultSet.close();
            preparedStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
        return teacher;
    }

    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        try {
            String query = "SELECT * FROM Teacher";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            ResultSet resultSet = preparedStmt.executeQuery();
            while (resultSet.next()) {
                String CNP = resultSet.getString("CNP");
                String name = resultSet.getString("name");
                int dateOfBirth = resultSet.getInt("dateOfBirth");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                Set<Subject> subjects = getTeacherSubjects(CNP);
                Set<String> classGroups = getTeacherClassGroups(CNP);
                Teacher teacher = new Teacher(CNP, name, dateOfBirth, phoneNumber, email, username, password, subjects, classGroups);
                teachers.add(teacher);
            }
            resultSet.close();
            preparedStmt.close();
        } catch (SQLException error) {
            System.out.println("Unable to get teachers: " + error.getMessage());
            System.exit(123);
        }

        return teachers;
    }
}
