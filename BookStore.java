package bookstoreapp;

import java.io.IOException;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author vguru
 */
public class BookStore extends Application {
    
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Book> books = new ArrayList<>();
    
    @Override
    public void start(Stage stage) {
        stage.setResizable(false);
        try {
            books = read("books");
            customers = read("customers");
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Please create the files 'books.txt' and 'customers.txt' first!");
        }
        Screen start = new LoginScreen();
        stage.setScene(new Scene(start.display(stage)));
        stage.sizeToScene(); 
        stage.show();
    }
    
    @Override
    public void stop() {
        try {
            write("books");
            write("customers");
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Please create the files 'books.txt' and 'customers.txt' first!");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static ArrayList<Customer> getCustomers() {
        return customers;
    }
    
    public static void addCustomer(Customer c) {
        customers.add(c);
    }
    
    public static void removeCustomer(Customer c) {
        customers.remove(c);
    }
    
    public static ArrayList<Book> getBooks() {
        return books;
    }
    
    public static void addBook(Book b) {
        books.add(b);
    }
    
    public static void removeBook(Book b) {
        books.remove(b);
    }
    
    public static void write(String type) throws IOException {
        Path path = Paths.get(type + ".txt");
        if ("books".equals(type)) {
            List<String> details = books.stream().map(item -> item.toString()).collect(Collectors.toList());
            Files.write(path, details, Charset.defaultCharset());
        }
        else {
            List<String> details = customers.stream().map(item -> item.toString()).collect(Collectors.toList());
            Files.write(path, details, Charset.defaultCharset());

        }
    }
    
    public static ArrayList read(String type) throws IOException {
        Path path = Paths.get(type + ".txt");
        if ("books".equals(type)) {
            List<String> text = Files.lines(path).collect(Collectors.toList());
            ArrayList<Book> books = new ArrayList<>();
            if (text.size() > 0) {
                for (String s : text) {
                    String[] d = s.split(" ");
                    books.add(new Book(d[0], Double.parseDouble(d[1])));
                }
            }
            return books;
        }
        else {
            List<String> text = Files.lines(path).collect(Collectors.toList());
            ArrayList<Customer> customers = new ArrayList<>();
            if (text.size() > 0) {
                for (String s : text) {
                    String[] d = s.split(" ");
                    customers.add(new Customer(d[0], d[1], Integer.parseInt(d[2])));
                }
            }
            return customers;
        }
    }
}
