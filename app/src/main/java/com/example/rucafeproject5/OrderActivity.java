package com.example.rucafeproject5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author Manveer Singh, Prasidh Sriram
 */
public class OrderActivity extends AppCompatActivity {
    private final static double SALES_TAX = 0.06625;
    private static TextInputEditText currentSubtotal, currentSalesTaxAmt, finalTotal;
    public static double tempSubtotal = 0;
    public static ArrayList<String> arrayList = new ArrayList<>();
    private Button placeCurrentOrder, removeOrder;
    private Toast toast;
    private double currentTotal, withSalesTax, newTotal;
    private int currentPosition;
    private ListView currentOrder;
    public static String selected;
    public static Order orderObj = new Order();
    public static Order copy = new Order(orderObj);
    public static StoreOrders storeOrderObj;

    /**
     *
     * @param val
     * @return
     */
    public String twoDecimalPlaces(double val) {
        return String.format("%.02f", val);
    }

    public static String getValue() {
        String total = finalTotal.getText().toString();
        return total;
    }


    public void setOrder(Order order) {
        orderObj = order;
    }


    public void setStoreOrder(StoreOrders storeOrder) {
        storeOrderObj = storeOrder;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        currentOrder = (ListView)findViewById(R.id.currentOrderList);

        ArrayAdapter adapter4 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayList);
        currentOrder.setAdapter(adapter4);

        currentSubtotal = (TextInputEditText) findViewById(R.id.overallSubtotal);

        currentSubtotal.setText(twoDecimalPlaces(tempSubtotal));

        currentTotal = Double.parseDouble(currentSubtotal.getText().toString());
        currentSalesTaxAmt = (TextInputEditText) findViewById(R.id.priceWithSalesTax);

        withSalesTax = SALES_TAX * currentTotal;
        currentSalesTaxAmt.setText(twoDecimalPlaces(withSalesTax));

        newTotal = withSalesTax + currentTotal;
        finalTotal = (TextInputEditText) findViewById(R.id.finalTotalVal);
        finalTotal.setText(twoDecimalPlaces(newTotal));

        placeCurrentOrder = (Button) findViewById(R.id.placeCurrentOrder);
        removeOrder = (Button) findViewById(R.id.removeOrder);

        removeOrder.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                for (MenuItem item : orderObj.getItems()) {
                    if(item.toString().equals(selected)) {
                        currentTotal -= item.getItemPrice();
                        arrayList.remove(currentPosition);
                        Toast toast = Toast.makeText(OrderActivity.this, "Order Removed!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
                currentSubtotal.setText(twoDecimalPlaces(currentTotal));
                withSalesTax = currentTotal * SALES_TAX;
                currentSalesTaxAmt.setText(twoDecimalPlaces(withSalesTax));
                newTotal = withSalesTax + currentTotal;
                finalTotal.setText(twoDecimalPlaces(newTotal));
                orderObj.remove(selected);
            }
        });

        placeCurrentOrder.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                toast = Toast.makeText(OrderActivity.this, "Order Placed!", Toast.LENGTH_SHORT);
                toast.show();
                StoreActivity.finalTotal = Double.parseDouble(String.valueOf(getValue()));

                storeOrderObj.add(copy);
            }
        });

        currentOrder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(OrderActivity.this, "Selected: " + arrayList.get(position).toString(), Toast.LENGTH_SHORT).show();
                selected = arrayList.get(position).toString();
                currentPosition = position;
            }
        });


    }
}