package bookstoreapp;

/**
 *
 * @author vguru
 */

import javafx.collections.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.stage.Stage;

public class CustomerStartScreen {
    
    public Group display(Stage primaryStage, Customer cust, ObservableList<Book> books) {
        Group screen = new Group();
        
        Button logout = new Button("Logout");
        Button buy1 = new Button("Buy");
        Button buy2 = new Button("Redeem Points and Buy");
        
        TableView<Book> table = new TableView<>();
        
        // Message for Customer
        Text greeting = new Text("Welcome, " + cust.getUser() + ".\nYour status is: " + cust.getStatus());
        greeting.setFont(new Font(14));
        
        // Title column
        TableColumn<Book, String> title = new TableColumn<>("Title");
        title.setMinWidth(200);
        title.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Price column
        TableColumn<Book, Double> price = new TableColumn<>("Price");
        price.setMinWidth(100);
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        // Checkbox column
        TableColumn<Book, String> select = new TableColumn<>("");
        select.setMinWidth(100);
        select.setCellValueFactory(new PropertyValueFactory<>("select"));
        
        table.setItems(books);
        table.getColumns().addAll(title, price, select);
        
        BorderPane header = new BorderPane();
        HBox bot = new HBox();
        
        header.setCenter(greeting);
        bot.getChildren().addAll(buy1, buy2, logout);
        bot.setAlignment(Pos.BOTTOM_CENTER);
        bot.setSpacing(5);
        
        VBox vbox = new VBox();
        
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(40, 200, 30, 100));
        vbox.getChildren().addAll(header, table, bot);

        screen.getChildren().addAll(vbox);
        return screen;
    }
}
