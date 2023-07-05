import db.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogDL {
    private static Connection connection;

    public CatalogDL() throws Exception {
        connection = JDBC.getInstance();
    }

    public void createCatalog(Catalog catalog) {
        try {
            String query = "INSERT INTO Catalog (name, year) VALUES (?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, catalog.getClassName());
            preparedStmt.executeUpdate();
            preparedStmt.close();
        } catch (SQLException error) {
            System.out.println("Unable to create a new catalog: " + error.getMessage());
        }
    }

    public void deleteCatalog(int id) {
        try {
            String query = "DELETE FROM Catalog WHERE id = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, id);
            preparedStmt.executeUpdate();
            preparedStmt.close();
        } catch (SQLException error) {
            System.out.println("Unable to delete catalog: " + error.getMessage());
        }
    }

    public Catalog getCatalogById(String id) {
        Catalog catalog = null;
        try {
            String query = "SELECT * FROM Catalog WHERE id = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, id);
            ResultSet resultSet = preparedStmt.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                catalog = new Catalog(id, null, null);
            }
            resultSet.close();
            preparedStmt.close();
        } catch (SQLException error) {
            System.out.println("Unable to get catalog: " + error.getMessage());
        }
        return catalog;
    }

    public List<Catalog> getAllCatalogs() {
        List<Catalog> catalogs = new ArrayList<>();
        try {
            String query = "SELECT * FROM Catalog";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            ResultSet resultSet = preparedStmt.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                Catalog catalog = new Catalog(id, null, null);
                catalogs.add(catalog);
            }
            resultSet.close();
            preparedStmt.close();
        } catch (SQLException error) {
            System.out.println("Unable to get catalogs: " + error.getMessage());
        }
        return catalogs;
    }
}
