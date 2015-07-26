/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableview.demo;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField categoryField;
    @FXML
    private TextField priceField;
    @FXML
    private Label statusBarLabel;
    private Statement statement;
    @FXML
    private ListView<Product> productListView;
    private ObservableList<Product> products;
    @FXML
    private TableView<Product> productTableView;
    @FXML
    private TableColumn<Product, Number> idColumn;
    @FXML
    private TableColumn<Product, String> nameColumn;
    @FXML
    private TableColumn<Product, Number> priceColumn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String DB_URL = "jdbc:mysql://172.17.0.119/storedb";
        String DB_USER = "cse2015";
        String DB_PASS = "summer2015";
        products = FXCollections.observableArrayList();
        productListView.setItems(products);
        productTableView.setItems(products);
        idColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getProductId()));
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProductName()));
        priceColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getUnitPrice()));
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            statement = connection.createStatement();
            String query = "SELECT * FROM Product;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("productId");
                String name = resultSet.getString("productName");
                String category = resultSet.getString("category");
                double price = resultSet.getDouble("unitPrice");
                Product p = new Product(id, name, category, price);
                products.add(p);
            }
        } catch (SQLException ex) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Connecting to database");
            alert.setHeaderText("Authentication failed");
            alert.setContentText("You have entered wrong username\nor password or wrong URL");
            alert.showAndWait();
            System.exit(1);
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        statusBarLabel.setText("Connected to the database");
        /*
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Connecting to database");
        alert.setHeaderText("Connected to the database");
        alert.setContentText("Let's rock and roll!");
        alert.showAndWait();
                */
    }    

    @FXML
    private void handleResetAction(ActionEvent event) {
    }

    @FXML
    private void handleAddProductAction(ActionEvent event) {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        String category = categoryField.getText();
        double price = Double.parseDouble(priceField.getText());
        
        Product p = new Product(id, name, category, price);
        String query = "INSERT INTO Product VALUES(" 
                + p.getProductId() + ", '" 
                + p.getProductName() 
                + "', '" + p.getCategory() 
                + "', " + p.getUnitPrice() + ");";
        try {
            statement.executeUpdate(query);
            statusBarLabel.setText("Inserted " + p.getProductName() + " into database");
        } catch (SQLException ex) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Inserting Product");
            alert.setHeaderText("Product insertion failed");
            alert.setContentText("Failed to insert product\n" + p.getProductName());
            alert.showAndWait();
            
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
