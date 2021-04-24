package com.example.rucafeproject5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

/**
 * Activity class that directly controls our activity_coffee activity (.xml) file and has
 * all of the functionality of ordering coffee (quantity, size and any addOns requested by the user). This class
 * sets the onCreate and onClick functioalities for several components in our class (buttons, checkboxes, and has
 * a few getter methods as well).
 * @author Manveer Singh, Prasidh Sriram
 */
public class CoffeeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private Button placeOrder;
    private static String text;
    private static double total = 1.99;
    private Coffee coffee = new Coffee("Short", "1");
    private final static double ADD_ON_PRICE = 0.20; //fixed value
    private static CheckBox milk, caramel, syrup, whippedCream, cream;
    private static TextInputEditText coffeeSubtotal;
    private static Spinner spinner, spinner2;
    private final double default_subtotal_value = 0.00;

    /**
     * Getter method that returns the quantity chosen by the user using the spinner drop down list
     * @return quantity int selected by the user
     */
    public static int getQuantity() {
        int quantity = Integer.parseInt(spinner.getSelectedItem().toString());
        return quantity;
    }

    /**
     * Method that returns the type casted string version of total so it can be used in text fields
     * @return total of default coffee order in type string
     */
    public static String getValue() {
        String finalTotal = String.valueOf(total);
        return finalTotal;
    }

    /**
     * This method initializes our type Button, Checkbox, TextinputEditText variables to the ID of those in the activity_coffee.xml file,
     * populates the spinners with quantity, size, and implements functionality of each event
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        //set IDs now to all of our instances
        cream = (CheckBox) findViewById(R.id.creamCheckBox);
        whippedCream = (CheckBox) findViewById(R.id.whippedCreamCB);
        syrup = (CheckBox) findViewById(R.id.syrupCheckBox);
        milk = (CheckBox) findViewById(R.id.milkCheckBox);
        caramel = (CheckBox) findViewById(R.id.caramelCheckBox);
        coffeeSubtotal = (TextInputEditText) findViewById(R.id.coffeetotal);
        placeOrder = (Button) findViewById(R.id.coffeeButton);

        //populate the quantity of coffee from strings.xml
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.quantity, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        //populate the sizes of Coffee from strings.xml
        spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.size, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        //check boxes on click listeners first here
        whippedCream.setOnClickListener(new View.OnClickListener() {
            /**
             * If whipped cream checkbox is selected, add the price to total, if not subtract
             * also adds the object coffee using the add method and then updates the subtotal textview
             * with the current total price
             * @param view
             */
            @Override
            public void onClick(View view) {
                if (whippedCream.isChecked()) {
                    coffee.add("Whipped Cream");
                    total += (ADD_ON_PRICE * getQuantity());
                } else {
                    coffee.remove("Whipped Cream");
                    total -= (ADD_ON_PRICE * getQuantity());
                }
                coffeeSubtotal.setText(twoDecimalPlaces(total));
            }
        });

        cream.setOnClickListener(new View.OnClickListener() {
            /**
             * If cream checkbox is selected, add the price to total, if not subtract
             * also adds the object coffee using the add method and then updates the subtotal textview
             * with the current total price
             * @param view
             */
            @Override
            public void onClick(View view) {
                if (cream.isChecked()) {
                    coffee.add("Cream");
                    total += (ADD_ON_PRICE * getQuantity());
                } else {
                    coffee.remove("Cream");
                    total -= (ADD_ON_PRICE * getQuantity());
                }
                coffeeSubtotal.setText(twoDecimalPlaces(total));
            }
        });

        syrup.setOnClickListener(new View.OnClickListener() {
            /**
             * If syrup checkbox is selected, add the price to total, if not subtract
             * also adds the object coffee using the add method and then updates the subtotal textview
             * with the current total price
             * @param view
             */
            @Override
            public void onClick(View view) {
                if (syrup.isChecked()) {
                    coffee.add("Syrup");
                    total += (ADD_ON_PRICE * getQuantity());
                } else {
                    coffee.remove("Syrup");
                    total -= (ADD_ON_PRICE * getQuantity());
                }
                coffeeSubtotal.setText(twoDecimalPlaces(total));
            }
        });

        caramel.setOnClickListener(new View.OnClickListener() {
            /**
             * If caramel checkbox is selected, add the price to total, if not subtract
             * also adds the object coffee using the add method and then updates the subtotal textview
             * with the current total price
             * @param view
             */
            @Override
            public void onClick(View view) {
                if (caramel.isChecked()) {
                    coffee.add("Caramel");
                    total += (ADD_ON_PRICE * getQuantity());
                } else {
                    coffee.remove("Caramel");
                    total -= (ADD_ON_PRICE * getQuantity());
                }
                coffeeSubtotal.setText(twoDecimalPlaces(total));
            }
        });

        placeOrder.setOnClickListener(new View.OnClickListener() {
            /**
             * Places the order from coffee to current order activity along with
             * showing a toast message confirming the order
             * @param view
             */
            @Override
            public void onClick(View view) {
                coffee.itemPrice();
                OrderActivity.tempSubtotal += coffee.getItemPrice() ;
                OrderActivity.arrayList.add(coffee.toString());
                DonutOrderActivity.orderObj.add(coffee);
                Toast toast = Toast.makeText(CoffeeActivity.this, "Order Placed!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        milk.setOnClickListener(new View.OnClickListener() {
            /**
             * If milk checkbox is selected, add the price to total, if not subtract
             * also adds the object coffee using the add method and then updates the subtotal textview
             * with the current total price
             * @param view
             */
            @Override
            public void onClick(View view) {
                if (milk.isChecked()) {
                    coffee.add("Milk");
                    total += (ADD_ON_PRICE * getQuantity());
                } else {
                    coffee.remove("Milk");
                    total -= (ADD_ON_PRICE * getQuantity());
                }
                coffeeSubtotal.setText(twoDecimalPlaces(total));
            }
        });

    }

    /**
     * Method that calculates the price for coffee based on its size, quantity and makes several calls to
     * methods implemented in our coffee class. Everytime a size is selected, a toast message is displayed on the screen
     * as well. Along with calculating the right price, we also assign it to the subtotal coffee textView here.
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        int currAmount;
        if(text.equals("Short")){
            coffee.changeSize("Short");
            currAmount = getQuantity();
            coffee.changeQuantity(String.valueOf(currAmount));
            coffee.itemPrice();
            total = coffee.getItemPrice();
            helpClearCheckboxes();
            coffeeSubtotal.setText(twoDecimalPlaces(total));
        }else if(text.equals("Tall")){
            coffee.changeSize("Tall");
            currAmount = getQuantity();
            coffee.changeQuantity(String.valueOf(currAmount));
            coffee.itemPrice();
            total = coffee.getItemPrice();
            helpClearCheckboxes();
            coffeeSubtotal.setText(twoDecimalPlaces(total));
        }else if(text.equals("Venti")){
            coffee.changeSize("Venti");
            currAmount = getQuantity();
            coffee.changeQuantity(String.valueOf(currAmount));
            coffee.itemPrice();
            total = coffee.getItemPrice();
            helpClearCheckboxes();
            coffeeSubtotal.setText(twoDecimalPlaces(total));
        }else if(text.equals("Grande")){
            coffee.changeSize("Grande");
            currAmount = getQuantity();
            coffee.changeQuantity(String.valueOf(currAmount));
            coffee.itemPrice();
            total = coffee.getItemPrice();
            helpClearCheckboxes();
            coffeeSubtotal.setText(twoDecimalPlaces(total));
        }
    }

    /**
     * Method that ensures that all of the prices in coffee are only two decimal places
     * by using the String.format method
     * @param val of type double that gets passed in and converted to have two demical points
     * @return string of our paramater val to two decimal places
     */
    public String twoDecimalPlaces(double val){
        return String.format("%.02f", val);
    }

    /**
     * helper method that clears our check boxes components upon called (after placing order or selecting a different
     * coffee size)
     */
    public void helpClearCheckboxes(){
        milk.setChecked(false);
        cream.setChecked(false);
        whippedCream.setChecked(false);
        caramel.setChecked(false);
        syrup.setChecked(false);
    }

    /**
     * Method that gets called when setting up the activity, if nothing is selected, this
     * method sets our subtotal textView to 0.00 as nothing has been selected yet
     * @param parent
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        coffeeSubtotal.setText(twoDecimalPlaces(default_subtotal_value));
    }
}