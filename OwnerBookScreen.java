/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author a4rahim
 */
public class OwnerBooksScreen extends Application{
    private final TableView table = new TableView();
    private final ObservableList<Book> data =
            FXCollections.observableArrayList(
            new Book("Facial Recognition", 18.99));
    final HBox hb = new HBox();
    
    public static void main(String[] args){
        launch(args);
    }
    
    @Override
    public void start(Stage stage){
        Scene scene = new Scene(new Group());
        
        //Windows layout
        stage.setTitle("Owner Screen-View");
        stage.setWidth(300);
        stage.setHeight(500);
        
        //Table Header
        final Label label = new Label("Books Shelf");
        label.setFont(new Font("Arial", 20));
        
        table.setEditable(true);
        
        TableColumn BookName = new TableColumn("Book Name");
        BookName.setMinWidth(100);
        BookName.setCellValueFactory(
            new PropertyValueFactory<>("Book Name"));
        
        TableColumn BookPrice = new TableColumn("Book Price");
        
        table.getColumns().addAll(BookName, BookPrice);
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
        
        stage.setScene(scene);
        stage.show();
        
    } 
}
