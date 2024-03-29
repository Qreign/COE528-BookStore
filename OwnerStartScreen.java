package bookstoreapp;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class OwnerStartScreen {

    public Group display(){
        //not a clue as to what parameters go up here
        
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
            //idk how we're gonna switch through screens via main 
            //but heres where you'd change the scene
            //you'd go to the owner-books-screen
        });
        buttonCustomers.setOnAction(e ->{
            //you'd go to the owner-customers-screen here
        });
        buttonLogout.setOnAction(e ->{
            //you'd go to the login screen here
        });
        
        vbox.getChildren().addAll(buttonBooks, buttonCustomers, buttonLogout);
        vbox.setAlignment(Pos.CENTER);
        //adding buttons to a vertical column
        
        /*
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
        ^this is how i initialized the screen to test it using a main method
        but idk how the main is gonna be so i mimicked the CustomerStartScreen,
        feel free to change it, thanks again!
        */
        
        screen.getChildren().addAll(vbox);
        
        return screen;
    }
    
}
