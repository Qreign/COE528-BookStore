package bookstoreapp;

/**
 *
 * @author vguru
 */

import javafx.scene.control.CheckBox;

public class Book {
    private String name;
    private double price;
    private CheckBox select;
    
    public Book(String name, double price) {
        this.name = name;
        this.price = price;
        select = new CheckBox();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }

    public CheckBox getSelect() {
        return select;
    }

    public void setSelect(CheckBox select) {
        this.select = select;
    }
    
    @Override
    public String toString() {
        return name + " " + price + "\n";
    }
}
