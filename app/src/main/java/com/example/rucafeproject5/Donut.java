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
     *
     */
    public Donut() {

    }

    /**
     *
     * @param donut
     */
    public Donut(Donut donut) {
        flavor = new String(donut.getFlavor());
        quantity = new String(donut.getQuantity());
    }

    /**
     *
     * @param flavor
     * @param quantity
     */
    public Donut(String flavor, String quantity) {
        this.flavor = flavor;
        this.quantity = quantity;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return flavor + ", " + quantity;
    }

    /**
     *
     */
    @Override
    public void itemPrice() {
        setItemPrice(DONUT_PRICE * Integer.parseInt(quantity));
    }

    /**
     *
     * @return
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     *
     * @return
     */
    public String getQuantity() {
        return quantity;
    }
}