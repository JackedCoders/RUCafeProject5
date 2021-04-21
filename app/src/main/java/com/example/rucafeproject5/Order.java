package com.example.rucafeproject5;
import java.util.ArrayList;

/**
 * Backend order class that adds and removes objects based on user input along with having the most
 * important arrayLIst of type MenuItem that holds all of the orders printed to the store orders.
 * Class also has a toString method used to return description of orders
 * @author Manveer Singh, Prasidh Sriram
 */
public class Order implements Customizable{
    private ArrayList<MenuItem> orderHolderArray = new ArrayList<>();

    /**
     * toString method that returns all of the contents of our arrayList above
     * @return full contents of array list orderHolderArray
     */
    public String toString(){
        String res ="";
        for(int i = 0; i<this.orderHolderArray.size(); i++){
            res += this.orderHolderArray.get(i).toString();
        }
        return res;
    }

    /**
     * empty constructor for Order class
     */
    public Order(){

    }

    /**
     * Constructor that initializes order num to 1 so we can start off there and increment
     */
    public Order(Order order){
        for(MenuItem item: order.getMenuItems()) {

            if(item instanceof Donut) {
                Donut d = new Donut((Donut)item);
                orderHolderArray.add(d);
            }

            if(item instanceof Coffee) {
                Coffee c = new Coffee((Coffee)item);
                orderHolderArray.add(c);
            }
        }
    }

    /**
     * add method that overrides add in Customizable interface and adds objects to our arrayList
     * @param obj object we want to add
     * @return boolean true if successful
     */
    @Override
    public boolean add(Object obj){
        if(obj instanceof MenuItem) {
            orderHolderArray.add((MenuItem)obj);
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
    public boolean remove(Object obj){
        if(obj instanceof String) {
            for(MenuItem item: orderHolderArray) {
                if(obj.equals(item.toString())) {
                    orderHolderArray.remove(item);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Getter method that returns the contents of our arraylist orderHolderArray of type MenuItem
     * @return
     */
    public ArrayList<MenuItem> getMenuItems(){
        return this.orderHolderArray;
    }
}
