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
 *
 * @author Manveer Singh, Prasidh Sriram
 */
public class CoffeeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private final static double ADD_ON_PRICE = 0.20; //fixed
    private static CheckBox milk, caramel, syrup, whippedCream, cream;
    private static TextInputEditText coffeeSubtotal;
    private static Spinner spinner, spinner2;
    private Button placeOrder;
    private static String text;
    private static double total = 1.99;
    private Coffee coffee = new Coffee("Short", "1");
    public static Order orderObj = new Order();

    /**
     *
     * @return
     */
    public static int getQuantity() {
        int quantity = Integer.parseInt(spinner.getSelectedItem().toString());
        return quantity;
    }

    /**
     *
     * @return
     */
    public static String getValue() {
        String finalTotal = String.valueOf(total);
        return finalTotal;
    }


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
             *
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
             *
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
             *
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
             *
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
             * Once the "Place Order" button is selected, a toast appears to confirm the order placed
             * The subtotal in the Order Activity is updated with the coffee price
             * The array list adds the coffee order information
             * @param view
             */
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(CoffeeActivity.this, "Order Placed!", Toast.LENGTH_SHORT);
                toast.show();

                OrderActivity.tempSubtotal += Double.parseDouble(String.valueOf(getValue()));
                OrderActivity.arrayList.add(coffee.toString());

                orderObj.add(coffee);
            }
        });

        milk.setOnClickListener(new View.OnClickListener() {
            /**
             *
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
     *
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
     *
     * @param val
     * @return
     */
    public String twoDecimalPlaces(double val){
        return String.format("%.02f", val);
    }

    /**
     *
     */
    public void helpClearCheckboxes(){
        milk.setChecked(false);
        cream.setChecked(false);
        whippedCream.setChecked(false);
        caramel.setChecked(false);
        syrup.setChecked(false);
    }

    /**
     *
     * @param parent
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        coffeeSubtotal.setText(twoDecimalPlaces(0.00));
    }
}