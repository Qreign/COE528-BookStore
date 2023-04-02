package bookstoreapp;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.stage.Stage;

public class OwnerStartScreen extends Screen {

    public Group display(Stage stage){
        
        Group screen = new Group();
        VBox vbox = new VBox(10);
        
        Button buttonBooks = new Button("Books");
        buttonBooks.setMaxSize(100, 200);
        Button buttonCustomers = new Button("Customers");
        buttonCustomers.setMaxSize(100, 200);
        Button buttonLogout = new Button("Log Out");
        buttonLogout.setMaxSize(100, 200);
        //button sizing and initalization
        
        buttonBooks.setOnAction(e ->{
            //switches to owner-books-screen
            stage.setScene(new Scene(new OwnerBooksScreen().display(stage)));
        });
        buttonCustomers.setOnAction(e ->{
            //switches to owner-customers-screen
            stage.setScene(new Scene(new OwnerCustomersScreen().display(stage)));
        });
        buttonLogout.setOnAction(e ->{
            //switches to login-screen
            stage.setScene(new Scene(new LoginScreen().display(stage)));
        });
        
        vbox.getChildren().addAll(buttonBooks, buttonCustomers, buttonLogout);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(150));
        //adding buttons to a vertical column
        
        screen.getChildren().addAll(vbox);
        
        return screen;
    }
    
}
