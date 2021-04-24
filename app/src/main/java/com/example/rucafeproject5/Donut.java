package com.example.rucafeproject5;
/**
 * Back end Donut class that directly handles all of the calculations, add, remove and assignments for our
 * DonutView and DonutController files. This class also has a toString that allows us to print the contents to store
 * order GUI at the end of placing orders.
 * @author Manveer Singh, Prasidh Sriram
 */
public class Donut extends MenuItem {
    private static final double DONUT_PRICE = 1.39;
    private String flavor;
    private String quantity;

    /**
     * Method to create new donut objects and set flavor and quantity using our getter methods
     * @param donut object that gets passed to set flavor and quantity to
     */
    public Donut(Donut donut) {
        flavor = new String(donut.getFlavor());
        quantity = new String(donut.getQuantity());
    }

    /**
     * Method that calculates the price for each time by calling the setItemPrice method
     * in Menu item
     */
    @Override
    public void itemPrice() {
        set_price_of_item(DONUT_PRICE * Integer.parseInt(quantity));
    }

    /**
     * getter method that returns our private instance variable flavor
     * @return flavor
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * getter method that returns our private instance variable quantity
     * @return quantity of the Donut
     */
    public String getQuantity() {
        return quantity;
    }
    /**
     * Empty constructor that allows us to create Donut objects
     */
    public Donut() {

    }

    /**
     * Constructor that accepts two parameters and initializes our private instance variables
     * flavor and quantity to the parameters
     * @param flavor
     * @param quantity
     */
    public Donut(String flavor, String quantity) {
        this.flavor = flavor;
        this.quantity = quantity;
    }

    /**
     * toString method to print basic info about our donuts
     * @return
     */
    @Override
    public String toString() {
        return flavor + ", " + quantity;
    }


}