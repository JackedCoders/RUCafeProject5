package com.example.rucafeproject5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

/**
 * Activity class that directly controls our activity_donut_order.xml and has all of the functionality needed
 * for selecting the quantity and flavors of donuts. This class calculates the total for a specific donut flavor,
 * has a few getter methods and displays toast messages for certain actions (order is placed, donut selected etc)
 * @author Manveer Singh, Prasidh Sriram
 */
public class DonutOrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private final double DONUT_PRICE = 1.39;
    private static TextInputEditText donutTotal;
    private int quantity;
    private Spinner spinner3;
    private Button placeOrder;
    static TextView donutName;
    static double total = 0;
    static String donutCount;
    private Donut donut = new Donut("Glazed", "1");
    public static Order orderObj = new Order();
    private double default_value_donuts = 0.00;

    /**
     * Method to restrict our numbers to two decimal points only as required by project description
     * This method gets called throughout this class as a helper method
     * @param val value to restrict to two decimal points
     * @return string format of val
     */
    public String twoDecimalPoints(double val) {
        return String.format("%.02f", val);
    }

    /**
     * Method that populates our spinner with the quantity of donuts, initializes our button, textInputEditText
     * to be used in the activity along with displaying Toast messages when order is placed and then adds the donut
     * object to be added to the shopping cart
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut_order);
        //Populate the spinner with the quantity desired here
        spinner3 = findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.quantity, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(this);
        Intent intent = getIntent();
        String message = intent.getStringExtra(DonutActivity.SEND_MESSAGE);
        donutName = (TextView) findViewById(R.id.currentDonut);
        donutName.setText(message);
        donutTotal = (TextInputEditText) findViewById((R.id.donutTotal));
        donutTotal.setText(twoDecimalPoints(total));
        placeOrder = (Button) findViewById(R.id.placeDonutOrder);

        placeOrder.setOnClickListener(new View.OnClickListener() {
            /**
             * Display toast message when the order is placed and add the object to be added to
             * current order array list and update prices
             * @param view
             */
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(DonutOrderActivity.this, "Order Placed!", Toast.LENGTH_SHORT);
                toast.show();

                String quantity = spinner3.getSelectedItem().toString();

                donut = new Donut(donutName.getText().toString(), quantity);

                orderObj.add(donut);
                donut.itemPrice();
                OrderActivity.tempSubtotal += donut.getItemPrice();
                OrderActivity.arrayList.add(donut.toString());
            }
        });

    }

    /**
     * This void method calculates the total for donuts based on the count and then sets it
     * to our textInputLayout property for correct price for the donuts selected
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        donutCount = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), donutCount, Toast.LENGTH_SHORT).show();

        quantity = Integer.parseInt(parent.getItemAtPosition(position).toString());

        total = quantity * DONUT_PRICE;
        donutTotal.setText(twoDecimalPoints(total));
    }

    /**
     * Upon creation, if the quantity or donut is not selected then set the total for donuts to be exactly 0.00
     * @param parent
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        donutTotal.setText(twoDecimalPoints(default_value_donuts));
    }
}