package bookstoreapp;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import java.math.*;

/**
 *
 * @author Carlos Bolinas
 */
public class CustomerCostScreen {
    
    public Group display(Stage primaryStage, Customer c, double cost, boolean redeem){
        // Point calculation
        int reduction;
        if(redeem == true){
            // If customer doesn't have enoough points
            if (cost >= c.getPts()/100){
                reduction = c.getPts()/100;
            }
            // If customer has more than enough points
            else{
                reduction = (int)cost;
            }
            cost -= reduction;
            c.setPts(c.getPts() - reduction*100);
        }
        
        // 1 CAD spent = 10 pts added
        c.setPts(c.getPts() + ((int)cost*10));
        
        // Update status
        if (c.getPts() < 1000){
            c.setStatus("Silver");
        }else{
            c.setStatus("Gold");
        }
        
        
        Group screen = new Group();
        
        // Total Cost display
        Text totalCost = new Text("Total cost: $" + cost);
        totalCost.setFont(new Font(14));
        
        // Points and Status display
        Text mid = new Text("Points: " + c.getPts() + ", Status: " + c.getStatus());
        mid.setFont(new Font(14));
        
        // Logout button
        Button logout = new Button("Logout");
        logout.setOnAction(e ->{
            // Switch to login screen
        });
        
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(totalCost, mid, logout);
        
        screen.getChildren().addAll(vbox);
        
        return screen;
    }
}
