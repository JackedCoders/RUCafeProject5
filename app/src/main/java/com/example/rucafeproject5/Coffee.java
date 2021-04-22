package com.example.rucafeproject5;

import java.util.ArrayList;

/**
 * Back end Coffee class that directly handles all of the calculations, add, remove and assignments for our
 * CoffeeView and CoffeeController files. This class also has a toString that allows us to print the contents to store
 * order GUI at the end of placing orders.
 * @author Manveer Singh, Prasidh Sriram
 */

public class Coffee extends MenuItem implements Customizable {

    private static final double TALL = 0.50;
    private static final double GRANDE = 1.00;
    private static final double VENTI = 1.50;
    private static final double ADD_IN_PRICE = 0.20;
    private String size;
    private String quantity;
    private boolean milk;
    private boolean cream;
    private boolean whippedCream;
    private boolean syrup;
    private boolean caramel;

    public Coffee(Coffee coffee) {
        size  = new String(coffee.getSize());
        quantity = new String(coffee.getQuantity());
        milk = coffee.getMilk();
        cream = coffee.getCream();
        whippedCream = coffee.getWhippedCream();
        syrup = coffee.getSyrup();
        caramel = coffee.getCaramel();
    }

    public Coffee(String size, String quantity) {
        this.size = size;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        String result = "Coffee (" + quantity + "), " + size + " (";

        if (milk == true) {
            result += "Milk, ";
        }
        if (cream == true) {
            result += "Cream, ";
        }
        if (whippedCream == true) {
            result += "Whipped Cream, ";
        }
        if (syrup == true) {
            result += "Syrup, ";
        }
        if (caramel == true) {
            result += "Caramel, ";
        } else {
            result += "None ";
        }
        result += ")";
        return result;
    }

    @Override
    public void itemPrice() {
        double totalPrice = 1.99;
        if (size.equals("Short")) {
            totalPrice += 0;
        }
        if (size.equals("Tall")) {
            totalPrice += TALL;
        }
        if (size.equals("Grande")) {
            totalPrice += GRANDE;
        }
        if (size.equals("Venti")) {
            totalPrice += VENTI;
        }
        if (milk == true) {
            totalPrice += ADD_IN_PRICE;
        }
        if (cream == true) {
            totalPrice += ADD_IN_PRICE;
        }
        if (syrup == true) {
            totalPrice += ADD_IN_PRICE;
        }
        if (caramel == true) {
            totalPrice += ADD_IN_PRICE;
        }
        if (whippedCream == true) {
            totalPrice += ADD_IN_PRICE;
        }
        setItemPrice(totalPrice * Integer.parseInt(quantity));
    }

    @Override
    public boolean add(Object obj) {
        if (obj instanceof String) {
            if (obj.equals("Cream")) {
                cream = true;
            }
            if (obj.equals("Syrup")) {
                syrup = true;
            }
            if (obj.equals("Whipped Cream")) {
                whippedCream = true;
            }
            if (obj.equals("Caramel")) {
                caramel = true;
            }
            if (obj.equals("Milk")) {
                milk = true;
            }
        }
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        if (obj instanceof String) {
            if (obj.equals("Cream")) {
                cream = false;
            }
            if (obj.equals("Syrup")) {
                syrup = false;
            }
            if (obj.equals("Whipped Cream")) {
                whippedCream = false;
            }
            if (obj.equals("Caramel")) {
                caramel = false;
            }
            if (obj.equals("Milk")) {
                milk = false;
            }
        }
        return true;
    }

    public void changeSize(String size) {
        this.size = size;
    }

    public void changeQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public String getQuantity() {
        return quantity;
    }

    public boolean getMilk() {
        return milk;
    }


    public boolean getCream() {
        return cream;
    }

    public boolean getWhippedCream() {
        return whippedCream;
    }


    public boolean getSyrup() {
        return syrup;
    }


    public boolean getCaramel() {
        return caramel;
    }
}