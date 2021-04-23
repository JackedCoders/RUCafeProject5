package com.example.rucafeproject5;

import java.util.ArrayList;

/**
 *
 * @author Manveer Singh, Prasidh Sriram
 */
public class StoreOrders implements Customizable {

    public ArrayList<Order> allOrders = new ArrayList<Order>();

    /**
     * 
     * @param obj
     * @return
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
     *
     * @param obj
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
     *
     * @return
     */
    public ArrayList<Order> getAllOrders() {
        return allOrders;
    }
}