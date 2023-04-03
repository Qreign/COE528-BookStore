/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp;

import static bookstoreapp.BookStore.*;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.stage.Stage;
/**
 *
 * @author a4rahim
 */
public class OwnerBooksScreen extends Screen {

    public Group display(Stage stage) {
        Group obs = new Group();
        
        TableView<Book> table = new TableView<>();
        Label label = new Label("Books");
        label.setFont(new Font("Arial", 24));

        // Title column
        TableColumn<Book, String> title = new TableColumn<>("Title");
        title.setMinWidth(200);
        title.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Price column
        TableColumn<Book, Double> price = new TableColumn<>("Price");
        price.setMinWidth(100);
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        table.setItems(FXCollections.observableArrayList(getBooks()));
        table.getColumns().addAll(title, price);

        final TextField addName = new TextField();
        addName.setPromptText("Title");
        addName.setMaxWidth(title.getPrefWidth());
        final TextField addPrice = new TextField();
        addPrice.setMaxWidth(price.getPrefWidth());
        addPrice.setPromptText("Price");

        VBox vbox = new VBox();
        final Button add = new Button("Add");
        Label message = new Label("Price must be a number");
        message.setTextFill(Color.color(1,0,0));

        add.setOnAction((ActionEvent e) -> {
            try {
                double pr = Double.parseDouble(addPrice.getText());
                addBook(new Book(addName.getText(), pr));
                table.getItems().clear();
                table.setItems(FXCollections.observableArrayList(getBooks()));
                addName.clear();
                addPrice.clear();
                vbox.getChildren().remove(message); 
            }
            catch (NumberFormatException exception){
                if(!vbox.getChildren().contains(message)){
                    vbox.getChildren().add(message);
                }
            }
        });

        final Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> {
            Book selected = table.getSelectionModel().getSelectedItem();
            table.getItems().remove(selected);
            removeBook(selected);
        });

        HBox bot = new HBox();
        bot.getChildren().addAll(addName, addPrice, add, deleteButton);
        bot.setSpacing(3);
        bot.setAlignment(Pos.CENTER);
        
        Button back = new Button("Back");
        back.setOnAction(e -> {
            stage.setScene(new Scene(new OwnerStartScreen().display(stage)));
        });

        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(150));
        vbox.getChildren().addAll(label, table, bot, back);


        obs.getChildren().addAll(vbox);

        return obs;
    }
}
