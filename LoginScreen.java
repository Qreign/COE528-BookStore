package bookstoreapp;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.paint.Color;
import javafx.scene.*;

public class LoginScreen {
    
    public Group display(){
        
        Group screen = new Group();
        
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
            
            if(username.equals(owner.getUsername()) == true && password.equals(owner.getPassword()) == true){  
            //switch screen to owner main screen
            }
            else{
                boolean login = false;

                for(int i = 0; i < customers.size(); i++){
                    //customers is the arraylist of customers
                    
                    if(username.equals(customers.get(i).getUser()) == true && password.equals(customers.get(i).getPass()) == true){
                        
                        //switch screen to customer main screen
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
        //formatting the grid
        
        /*
        Scene scene = new Scene(gridPane, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
        ^this is how i initialized the screen to test it using a main method
        but idk how the main is gonna be so i mimicked the CustomerStartScreen,
        feel free to change it, thanks again!
        */
        
        screen.getChildren().addAll(gridPane);
        
        return screen;
    }
    
}
