package com.example.rucafeproject5;

import java.util.ArrayList;

public class StoreOrders implements Customizable {

    public ArrayList<Order> allOrders = new ArrayList<Order>();


    /**
     * Once the coffee or donut orders are placed, return true.
     * A new order is initialized and added to the overall order list
     * @param obj
     * @return boolean
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
     * Once the coffee or donut orders are removed, return true.
     * The order is removed from the overall order list.
     * @param obj
     * @return boolean
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
     * Method returns the array list containing all the orders
     * @return items
     */
    public ArrayList<Order> getAllOrders() {
        return allOrders;
    }
}