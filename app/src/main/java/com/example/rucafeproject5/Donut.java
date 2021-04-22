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

    public Donut() {

    }

    public Donut(Donut donut) {
        flavor = new String(donut.getFlavor());
        quantity = new String(donut.getQuantity());
    }


    public Donut(String flavor, String quantity) {
        this.flavor = flavor;
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return flavor + ", " + quantity;
    }


    @Override
    public void itemPrice() {
        setItemPrice(DONUT_PRICE * Integer.parseInt(quantity));
    }


    public String getFlavor() {
        return flavor;
    }


    public String getQuantity() {
        return quantity;
    }
}