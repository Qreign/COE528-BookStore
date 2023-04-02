package bookstoreapp;

import static bookstoreapp.BookStore.*;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.paint.Color;
import javafx.scene.*;
import javafx.stage.Stage;

public class LoginScreen extends Screen {
    
    public Group display(Stage stage) {
        
        Group screen = new Group();
        ArrayList<Customer> customers = getCustomers();
        
        TextField fieldUsername = new TextField();
        TextField fieldPassword = new TextField();
        
        Label greeting = new Label("Welcome to the Bookstore App!");
        Label labelUser = new Label("Username:");
        Label labelPass = new Label("Password: ");
        Label errorLogin = new Label("");
        
        Button buttonLogin = new Button("Login");
        buttonLogin.setMaxSize(100, 200);
        //button sizing and initalization
        
        buttonLogin.setOnAction(e ->{
            
            String username = fieldUsername.getText();
            String password = fieldPassword.getText();
            
            if(username.equals("admin") && password.equals("admin")){  
            //switch screen to owner main screen
                stage.setScene(new Scene(new OwnerStartScreen().display(stage)));
            }
            else{
                boolean login = false;

                for(int i = 0; i < customers.size(); i++){
                    //customers is the arraylist of customers
                    
                    if(username.equals(customers.get(i).getUser()) && password.equals(customers.get(i).getPass())){
                        
                        //switch screen to customer main screen           
                        stage.setScene(new Scene(new CustomerStartScreen().display(stage, customers.get(i),  FXCollections.observableArrayList(getBooks()))));
                        login = true;
                    }
                }
           
                if(login == false){
                    
                    errorLogin.setText("Incorrect Login Credentials!");
                    errorLogin.setTextFill(Color.color(1,0,0));
                    fieldPassword.clear();
                }
            }
            
        });
        
        GridPane gridPane = new GridPane();
        
        gridPane.add(greeting, 0, 0);
        gridPane.add(labelUser, 0, 1);
        gridPane.add(labelPass, 0, 2);
        gridPane.add(fieldUsername, 1, 1);
        gridPane.add(fieldPassword, 1, 2);
        gridPane.add(buttonLogin, 1, 3);
        gridPane.add(errorLogin, 1, 4);
        //adding all the elements to a grid
        
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(100));
        //formatting the grid
        
        screen.getChildren().addAll(gridPane);
        
        return screen;
    }
    
}
