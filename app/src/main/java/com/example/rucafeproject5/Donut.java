package com.example.rucafeproject5;

/**
 * Back end Donut class that directly handles all of the calculations, add, remove and assignments for our
 * DonutView and DonutController files. This class also has a toString that allows us to print the contents to store
 * order GUI at the end of placing orders.
 * @author Manveer Singh, Prasidh Sriram
 */
public class Donut extends MenuItem{

    final static double YEAST_DONUT_PRICE = 1.39;
    final static double CAKE_DONUT_PRICE = 1.59;
    final static double DONUT_HOLE_PRICE = 0.33;
    final int YEAST_DONUT_VAL = 0;
    final int CAKE_DONUT_VAL = 1;
    final int DONUT_HOLE_VAL = 2;
    private int donutType; //0==yeast, 1==cake, 2==donut hole
    private String quantityOfDonut;
    private String donutName;
    private String donutFlavor;


    /**
     * setter method to assign this private instance var quantityOfDonut to parameter quantityOfDonut
     * @param quantityOfDonut # of donuts to add
     */
    public void setQuantityOfDonut(int quantityOfDonut) {

        this.quantityOfDonut = quantityOfDonut +"";
    }


    /**
     * getter method that returns the donut type
     * @return
     */
    public int getDonutType() {
        return donutType;
    }

    /**
     * empty constructor that allows for creation of donut objects
     */
    public Donut(){

    }
    /**
     * Donut class constructor to create a donut object
     * @param donutType either 0,1 or 2. 0 for Yeast, 1 for Cake, 2 for Donut Hole
     */
    public Donut(int donutType, String donutFlavor, String quantityDonut){
        this.donutType = donutType;
        this.donutFlavor = donutFlavor;
        this.quantityOfDonut = quantityDonut;
        if(donutType == YEAST_DONUT_VAL){
            super.itemPrice(Integer.parseInt(quantityDonut)*YEAST_DONUT_PRICE);
        }if(donutType == CAKE_DONUT_VAL){
            super.itemPrice(Integer.parseInt(quantityDonut)*CAKE_DONUT_PRICE);
        }if(donutType == DONUT_HOLE_VAL){
            super.itemPrice(Integer.parseInt(quantityDonut)*DONUT_HOLE_PRICE);
        }

    }

    /**
     * allows to create donut objects based on donut type
     * @param d
     */
    public Donut(Donut d){
        donutType = d.getDonutType();
        if(donutType == YEAST_DONUT_VAL){
            super.itemPrice(YEAST_DONUT_PRICE);
        }if(donutType == CAKE_DONUT_VAL){
            super.itemPrice(CAKE_DONUT_PRICE);
        }if(donutType == DONUT_HOLE_VAL){
            super.itemPrice(DONUT_HOLE_PRICE);
        }
    }

    /**
     * Constructor with different parameter that assigns our private instance variable donutName to parameter donutName
     * @param donutName name of the donut
     */
    public Donut(String donutName){
        this.donutName = donutName;
    }

    /**
     * Returns itemPrice variable from our super class menuItem
     * @return price of the menuItem
     */
    public double itemPrice(){
        return super.getItemPrice();
    }

    /**
     * toString method to display info about donut orders
     * @return string of info about order
     */
    @Override
    public String toString(){
        String donutTypName ="";
        if(this.donutType ==0){
            return "Yeast Donut,[" + this.quantityOfDonut + "]";
        }else if(this.donutType ==CAKE_DONUT_VAL){
            return "Cake Donut,[" + this.quantityOfDonut + "]";
        }else if(this.donutType ==DONUT_HOLE_VAL){
            return "Donut Hole,[" + this.quantityOfDonut + "]";
        }else{
            return donutTypName + ", " + this.donutFlavor + "[" + this.quantityOfDonut + "]";
        }

    }

}
