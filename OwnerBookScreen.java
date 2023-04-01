/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp;

import java.util.Set;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author a4rahim
 */
public class OwnerBooksScreen extends Application{
    private final TableView table = new TableView();

    //Pre-made books
    
    //main Class
    public static void main(String[] args){
        launch(args);
    }
    
    @Override
    public void start(Stage stage){
        Scene scene = new Scene(new Group());
        
        //Windows layout
        stage.setTitle("Management books-Screen");
        stage.setWidth(700);
        stage.setHeight(700);
        
        //Table Header
        final Label label = new Label("Books Shelf");
        label.setFont(new Font("Arial", 20));
        
        table.setEditable(true);
                
        TableColumn BookName = new TableColumn("Book Name");    //BookName Columns
        BookName.setMinWidth(100);
        BookName.setCellValueFactory(
            new PropertyValueFactory<>("name"));
        
        TableColumn BookPrice = new TableColumn("Book Price");  //Price Columns
        BookPrice.setMinWidth(100);
        BookPrice.setCellValueFactory(
            new PropertyValueFactory<>("price"));
        
        TableColumn select = new TableColumn("Select");         //checkbox - will be added here
        select.setCellValueFactory(
            new PropertyValueFactory<>("select"));
        
        
        table.getColumns().addAll(BookName, BookPrice, select);
        
        final VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(95, 0, 0, 200));
        vbox.getChildren().addAll(label, table);
        
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        
        stage.setScene(scene);
        stage.show();
    }
    
}
