package bookstoreapp;

/**
 *
 * @author vguru
 */

import java.nio.file.*;
import java.nio.charset.Charset;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class FileManager {
    public static void write(ArrayList<Object> items, String type) throws IOException {
        Path path = Paths.get(type + ".txt");
        List<String> details = items.stream().map(item -> item.toString()).collect(Collectors.toList());
        Files.write(path, details, Charset.defaultCharset());
    }
    
    public static ArrayList read(String type) throws IOException {
        Path path = Paths.get(type + ".txt");
        if (type == "books") {
            List<String> text = Files.lines(path).collect(Collectors.toList());
            ArrayList<Book> books = new ArrayList<>();
            for (String s : text) {
                String[] d = s.split(" ");
                books.add(new Book(d[0], Double.parseDouble(d[1])));
            }
            return books;
        }
        else {
            List<String> text = Files.lines(path).collect(Collectors.toList());
            ArrayList<Customer> customers = new ArrayList<>();
            for (String s : text) {
                String[] d = s.split(" ");
                customers.add(new Customer(d[0], d[1], Integer.parseInt(d[2])));
            }
            return customers;
        }
    }
}
