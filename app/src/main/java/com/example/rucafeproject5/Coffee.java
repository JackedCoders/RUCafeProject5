package com.example.rucafeproject5;

/**
 * Back end Coffee class that directly handles all of the calculations, add, remove and assignments for our
 * CoffeeView and CoffeeController files. This class also has a toString that allows us to print the contents to store
 * order GUI at the end of placing orders.
 * @author Manveer Singh, Prasidh Sriram
 */
public class Coffee extends MenuItem implements Customizable {
    private String sizeOfCoffee;
    private String quantityOfCoffee;
    private boolean milk;
    private boolean cream;
    private boolean whippedCream;
    private boolean syrup;
    private boolean caramel;
    private static final double TALL = 0.50;
    private static final double GRANDE = 1.00;
    private static final double VENTI = 1.50;
    private static final double PRICE_FOR_ADD_ON = 0.20;

    /**
     * getter method to return the milk add on
     * @return private instance variable milk
     */
    public boolean getMilk() {
        return milk;
    }

    /**
     * getter method to return the cream add on
     * @return private instance variable cream
     */
    public boolean getCream() {
        return cream;
    }

    /**
     * getter method to return the whipped cream add on
     * @return private instance variable whipped cream
     */
    public boolean getWhippedCream() {
        return whippedCream;
    }

    /**
     * Method that changes the size of the coffee to our private instance variable size to the parameter
     * @param size
     */
    public void changeSize(String size) {
        this.sizeOfCoffee = size;
    }

    /**
     * Method that changes the quantity of the coffee ordered to the parameter being passed in
     * @param quantity
     */
    public void changeQuantity(String quantity) {
        this.quantityOfCoffee = quantity;
    }

    /**
     * getter method to return the size of the coffee
     * @return private instance variable size
     */
    public String getSizeOfCoffee() {
        return sizeOfCoffee;
    }

    /**
     * getter method to return the quantity of the coffee
     * @return private instance variable quantity
     */
    public String getQuantityOfCoffee() {
        return quantityOfCoffee;
    }

    /**
     * getter method to return the syrup add on
     * @return private instance variable syrup
     */
    public boolean getSyrup() {
        return syrup;
    }

    /**
     * getter method to return the caramel add on
     * @return private instance variable caramel
     */
    public boolean getCaramel() {
        return caramel;
    }

    /**
     * Coffee constructor that sets our private instance variables size and quantity to the parameters
     * @param sizeOfCoffee of coffee
     * @param quantityOfCoffee # of coffees
     */
    public Coffee(String sizeOfCoffee, String quantityOfCoffee) {
        this.sizeOfCoffee = sizeOfCoffee;
        this.quantityOfCoffee = quantityOfCoffee;
    }

    /**
     * Coffee constructor that allows us to pass a coffee object and set certain properties properly
     * @param coffee object that we're passing in
     */
    public Coffee(Coffee coffee) {
        sizeOfCoffee = new String(coffee.getSizeOfCoffee());
        quantityOfCoffee = new String(coffee.getQuantityOfCoffee());
        milk = coffee.getMilk();
        cream = coffee.getCream();
        whippedCream = coffee.getWhippedCream();
        syrup = coffee.getSyrup();
        caramel = coffee.getCaramel();
    }

    /**
     * add method that overrides the add in Customizable and adds coffee objects to current order and
     * store order
     * @param obj object to add
     * @return true
     */
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

    /**
     * remove method that overrides the remove in Customizable and removes coffee objects to current order
     * and store order
     * @param obj object to remove
     * @return true
     */
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

    /**
     * toString method to print coffee info to other activities
     * @return
     */
    @Override
    public String toString() {
        String result = "Coffee (" + quantityOfCoffee + "), " + sizeOfCoffee + " (";

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

    /**
     * method calculates the item price for coffee order based on coffee sizes and add ons
     * overrides the itemPrice in MenuItem
     */
    @Override
    public void itemPrice() {
        double sum = 1.99;
        if (sizeOfCoffee.equals("Short")) {
            sum += 0;
        }
        if (sizeOfCoffee.equals("Tall")) {
            sum += TALL;
        }
        if (sizeOfCoffee.equals("Grande")) {
            sum += GRANDE;
        }
        if (sizeOfCoffee.equals("Venti")) {
            sum += VENTI;
        }
        if (milk == true) {
            sum += PRICE_FOR_ADD_ON;
        }
        if (cream == true) {
            sum += PRICE_FOR_ADD_ON;
        }
        if (syrup == true) {
            sum += PRICE_FOR_ADD_ON;
        }
        if (caramel == true) {
            sum += PRICE_FOR_ADD_ON;
        }
        if (whippedCream == true) {
            sum += PRICE_FOR_ADD_ON;
        }
        set_price_of_item(sum * Integer.parseInt(quantityOfCoffee));
    }
}