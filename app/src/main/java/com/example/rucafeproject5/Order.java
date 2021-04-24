package com.example.rucafeproject5;
import java.util.ArrayList;

/**
 * Backend order class that adds and removes objects based on user input along with having the most
 * important arrayLIst of type MenuItem that holds all of the orders printed to the store orders.
 * Class also has a toString method used to return description of orders
 * @author Manveer Singh, Prasidh Sriram
 */
public class Order implements Customizable {

    private ArrayList<MenuItem> all_items_in_order = new ArrayList<MenuItem>();

    /**
     * add method that overrides add in Customizable interface and adds objects to our arrayList
     * @param obj object we want to add
     * @return boolean true if successful
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof MenuItem) {
            all_items_in_order.add((MenuItem) obj);
            return true;
        }
        return false;
    }

    /**
     * remove method that overrides add in Customizable interface and remove objects from our arrayList
     * @param obj object we want to remove
     * @return boolean true if successful
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof String) {
            for (MenuItem item : all_items_in_order) {
                if (obj.equals(item.toString())) {
                    all_items_in_order.remove(item);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Empty constructor that can be called and not have to pass parameters
     */
    public Order() {

    }

    /**
     * Constructor that creates new Donut and Coffee objects if the item being passed in
     * is an instance of Donut or Coffee respectively
     * @param order
     */
    public Order(Order order) {
        for (MenuItem item : order.getAll_items_in_order()) {
            if (item instanceof Donut) {
                Donut donut = new Donut((Donut) item);
                all_items_in_order.add(donut);
            }
            if (item instanceof Coffee) {
                Coffee coffee = new Coffee((Coffee) item);
                all_items_in_order.add(coffee);
            }
        }
    }



    /**
     * Getter method that returns the contents of our array list items of type MenuItem
     * @return
     */
    public ArrayList<MenuItem> getAll_items_in_order() {
        return all_items_in_order;
    }
}