package com.example.rucafeproject5;
/**
 * MenuItem class is considered to be the parent class of all sub classes in the project (donuts, coffee etc)
 * Every class that is related to our mainMenu GUI must extend this class
 * itemPrice is protected so that we can access it in Donut and Coffee classes
 * @author Manveer Singh, Prasidh Sriram
 */
public class MenuItem {

    private double itemprice;


    public void itemPrice() {

    }


    public double getItemPrice() {
        return itemprice;
    }


    public void setItemPrice(double price) {
        itemprice = price;
    }
}