package com.example.rucafeproject5;
import java.util.ArrayList;

/**
 * Backend order class that adds and removes objects based on user input along with having the most
 * important arrayLIst of type MenuItem that holds all of the orders printed to the store orders.
 * Class also has a toString method used to return description of orders
 * @author Manveer Singh, Prasidh Sriram
 */
import java.util.ArrayList;

/**
 *
 * @author Manveer Singh, Prasidh Sriram
 */
public class Order implements Customizable {

    private ArrayList<MenuItem> items = new ArrayList<MenuItem>();

    /**
     *
     */
    public Order() {

    }

    /**
     *
     * @param order
     */
    public Order(Order order) {
        for (MenuItem item : order.getItems()) {
            if (item instanceof Donut) {
                Donut donut = new Donut((Donut) item);
                items.add(donut);
            }
            if (item instanceof Coffee) {
                Coffee coffee = new Coffee((Coffee) item);
                items.add(coffee);
            }
        }
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof MenuItem) {
            items.add((MenuItem) obj);
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
        if (obj instanceof String) {
            for (MenuItem item : items) {
                if (obj.equals(item.toString())) {
                    items.remove(item);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @return
     */
    public ArrayList<MenuItem> getItems() {
        return items;
    }
}