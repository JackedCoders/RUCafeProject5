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
 *
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

    /**
     *
     * @param val
     * @return
     */
    public String twoDecimalPoints(double val) {
        return String.format("%.02f", val);
    }

    /**
     *
     * @return
     */
    public static String getValue() {
        String finalTotal = donutTotal.getText().toString();
        return finalTotal;
    }


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
             *
             * @param view
             */
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(DonutOrderActivity.this, "Order Placed!", Toast.LENGTH_SHORT);
                toast.show();

                String quantity = spinner3.getSelectedItem().toString();

                donut = new Donut(donutName.getText().toString(), quantity);

                orderObj.add(donut);

                OrderActivity.tempSubtotal += Double.parseDouble(String.valueOf(getValue()));
                OrderActivity.arrayList.add(donut.toString());
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
        donutCount = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), donutCount, Toast.LENGTH_SHORT).show();

        quantity = Integer.parseInt(parent.getItemAtPosition(position).toString());

        total = quantity * DONUT_PRICE;
        donutTotal.setText(twoDecimalPoints(total));
    }

    /**
     *
     * @param parent
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        donutTotal.setText(twoDecimalPoints(0.00));
    }
}