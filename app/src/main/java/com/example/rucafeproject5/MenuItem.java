package com.example.rucafeproject5;
/**
 * MenuItem class is considered to be the parent class of all sub classes in the project (donuts, coffee etc)
 * Every class that is related to our mainMenu GUI must extend this class
 * itemPrice is protected so that we can access it in Donut and Coffee classes
 * @author Manveer Singh, Prasidh Sriram
 */
public class MenuItem {
    private double price_per_item;

    /**
     * Getter method that returns our private instance variable price_per_item
     * @return price_per_item double
     */
    public double getItemPrice() {
        return price_per_item;
    }

    /**
     * setter method that sets our private instance variable price_per_item to parameter price
     * @param price
     */
    public void set_price_of_item(double price) {
        price_per_item = price;
    }

    /**
     * Empty method that gets over written in all of the subclasses which MenuItems extends to
     */
    public void itemPrice() {

    }
}