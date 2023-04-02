package bookstoreapp;

import static bookstoreapp.BookStore.*;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.paint.*;

public class OwnerCustomersScreen extends Screen {
    
    public Group display(Stage stage) {
           
        Group ct = new Group();
        VBox vbox = new VBox();

        vbox.setPadding(new Insets(0, 150, 60, 0));
        vbox.setAlignment(Pos.CENTER);

        Label label = new Label("Customers");
        label.setFont(new Font("Arial", 24));

        // Set up table columns
        TableColumn<Customer, String> usernameCol = new TableColumn<>("Username");

        usernameCol.setMinWidth(150);

        usernameCol.setCellValueFactory(new PropertyValueFactory<>("user"));

        TableColumn<Customer, String> passwordCol = new TableColumn<>("Password");

        passwordCol.setMinWidth(150);

        passwordCol.setCellValueFactory(new PropertyValueFactory<>("pass"));

        TableColumn<Customer, Integer> pointsCol = new TableColumn<>("Points");

        pointsCol.setMinWidth(120);

        pointsCol.setCellValueFactory(new PropertyValueFactory<>("pts"));

        TableView<Customer> customersTable = new TableView<>();
        customersTable.setItems(FXCollections.observableArrayList(getCustomers()));
        customersTable.getColumns().addAll(usernameCol, passwordCol, pointsCol);

        // Set up add and delete buttons
        final TextField addUsername = new TextField();
        addUsername.setPromptText("Username");
        addUsername.setMaxWidth(usernameCol.getPrefWidth());

        final TextField addPassword = new TextField();
        addPassword.setPromptText("Password");
        addPassword.setMaxWidth(passwordCol.getPrefWidth());
        

        final Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            String newUsername = addUsername.getText().trim();
            String newPassword = addPassword.getText().trim();
            Label message = new Label("Please enter a unique Username and Password");
            message.setTextFill(Color.color(1, 0, 0));
            if (newUsername.isEmpty() || newPassword.isEmpty()) {
                // Show error message if either field is empty
                vbox.getChildren().add(message);
                return;
            }

            for (Customer c : getCustomers()) {
                if (c.getUser() .equals(newUsername)) {
                    // Show error message if username already exists
                    vbox.getChildren().add(message);
                    return;
                }
            }

            // Add new customer to owner's list and refresh table
            Customer newCustomer = new Customer(newUsername, newPassword, 0);
            addCustomer(newCustomer);
            customersTable.getItems().add(newCustomer);
            addUsername.clear();
            addPassword.clear();
        });
        
        final Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> {
            Label message = new Label("Please select a row");
            Customer selectedCustomer = customersTable.getSelectionModel().getSelectedItem();
            message.setTextFill(Color.color(1, 0, 0));
            if (selectedCustomer == null) {
                // Show error message if no customer is selected
                vbox.getChildren().add(message);
                return;
            }
            removeCustomer(selectedCustomer);
            customersTable.getItems().remove(selectedCustomer);
        });
        
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            stage.setScene(new Scene(new OwnerStartScreen().display(stage)));
        });
        HBox hb = new HBox(5);
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll(addUsername, addPassword, addButton, deleteButton);
        
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(100));
        vbox.getChildren().addAll(label, customersTable, hb, backButton);
        ct.getChildren().addAll(vbox);
        return ct;
    }

}
