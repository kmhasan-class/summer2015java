/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableview.demo.section.pkg2;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private TextField addressField;
    @FXML
    private Label statusBarLabel;
    private Statement statement;
    @FXML
    private ListView<Supplier> supplierListView;
    private ObservableList<Supplier> suppliers;
    @FXML
    private TableView<Supplier> supplierTableView;
    @FXML
    private TableColumn<Supplier, Number> idColumn;
    @FXML
    private TableColumn<Supplier, String> nameColumn;
    @FXML
    private TableColumn<Supplier, String> addressColumn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String DB_URL = "jdbc:mysql://172.17.0.119/storedb";
        String DB_USER = "cse2015";
        String DB_PASS = "summer2015";
    
        suppliers = FXCollections.observableArrayList();
        supplierListView.setItems(suppliers);
        supplierTableView.setItems(suppliers);
        idColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()));
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        addressColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress()));
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            statement = connection.createStatement();
            String query = "SELECT * FROM Supplier;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("supplierId");
                String name = resultSet.getString("supplierName");
                String address = resultSet.getString("address");
                Supplier s = new Supplier(id, name, address);
                suppliers.add(s);
            }
        } catch (SQLException ex) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Connecting to the Database");
            alert.setHeaderText("Authentication failed");
            alert.setContentText("Could not connect to the database.\nYou may have provided wrong url, wrong user\nname or wrong password.");
            alert.showAndWait();
            System.exit(1);
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        statusBarLabel.setText("Connected to the database");
    }    

    @FXML
    private void handleResetAction(ActionEvent event) {
    }

    @FXML
    private void handleAddAction(ActionEvent event) {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        String address = addressField.getText();
        Supplier s = new Supplier(id, name, address);
        String query = "INSERT INTO Supplier VALUES(" + s.getId() + ", '" + s.getName() + "', '" + s.getAddress() + "');";
        try {
            statement.execute(query);
            statusBarLabel.setText("Added supplier " + s.getName() + " to the database");
            idField.setText("");
            nameField.setText("");
            addressField.setText("");
        } catch (SQLException ex) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Adding supplier to the database");
            alert.setHeaderText("Supplier insertion failed");
            alert.setContentText("Could not add supplier " + s.getName());
            alert.showAndWait();
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
