package com.example.rucafeproject5;

import java.util.ArrayList;

/**
 * Backend file that contains the arraylist of order for all the store orders.
 * This class has an add and remove method that overrides of Cusomizable interface along with a getter method to
 * return the contents of the arraylist
 * @author Manveer Singh, Prasidh Sriram
 */
public class StoreOrders implements Customizable {

    public ArrayList<Order> allOrders = new ArrayList<Order>();

    /**
     * adds the order obj to the arraylist
     * @param obj whwat we want to add
     * @return what we want to add
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof Order) {
            allOrders.add((Order) obj);
            return true;
        }
        return false;
    }

    /**
     * removes the order obj from the arraylist
     * @param obj what we want to remove
     * @return
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Order) {
            allOrders.remove((Order) obj);
            return true;
        }
        return false;
    }

    /**
     * getter method that returns the contents of allOrders above
     * @return everything inside the array
     */
    public ArrayList<Order> getAllOrders() {
        return allOrders;
    }
}