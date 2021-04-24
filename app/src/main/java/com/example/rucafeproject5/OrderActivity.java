package com.example.rucafeproject5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

/**
 * Activity class that directly controls our activity_order.xml and has all of the functionality needed to
 * view, delete, and place orders to the store. This class has a few getter methods and setter methods that
 * allow us to pass data using objects within activities along with our onCreate and onClick methods that
 * control certain behavior within the activity
 * @author Manveer Singh, Prasidh Sriram
 */
public class OrderActivity extends AppCompatActivity {
    public final static double SALES_TAX = 0.06625;
    private static TextInputEditText currentSubtotal, currentSalesTaxAmt, finalTotal;
    public static double tempSubtotal = 0;
    public static ArrayList<String> arrayList = new ArrayList<>();
    private Button placeCurrentOrder1;
    private Toast toast;
    private double currentTotal, withSalesTax, newTotal;
    private ListView currentOrder;
    public static String selected;
    public static StoreOrders storeOrderObj = new StoreOrders();

    /**
     * Method to restrict our numbers to two decimal points only as required by project description
     * This method gets called throughout this class as a helper method
     * @param val value to restrict to two decimal points
     * @return string format of val
     */
    public String twoDecimalPlaces(double val) {
        return String.format("%.02f", val);
    }

    /**
     * getter method that returns the value in our finalTotal textInputEditText, converts it into
     * a string then returns it to use later on
     * @return value of finalTotal in string format
     */
    public static String getValue() {
        String total = finalTotal.getText().toString();
        return total;
    }


    /**
     * setter method that assigns our public static storeOrderObj to the passed parameter
     * @param storeOrder
     */
    public void setStoreOrder(StoreOrders storeOrder) {
        storeOrderObj = storeOrder;
    }

    /**
     * Method that initializes our variables to their respective ListView, TextInputEditText and buttons along with
     * a few onClick methods to control the behavior and functionality of our place order button
     * @param savedInstanceState
     */
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

        placeCurrentOrder1 = (Button) findViewById(R.id.placeCurrentOrder);
        /**
         * onClick method for our place order button that displays a toast messages and adds our
         * selected order to the store orders activity object along with doing the updated
         * calculations for our order then displays a toast message stating the order was placed
         */
        placeCurrentOrder1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(adapter4.getCount() ==0){
                    Toast.makeText(getApplicationContext(), "No orders to be placed. Try again", Toast.LENGTH_LONG).show();
                    return;
                }
                Order deep_copy = new Order(DonutOrderActivity.orderObj);

                storeOrderObj.add(deep_copy);
                arrayList.clear();

                adapter4.notifyDataSetChanged();;
                DonutOrderActivity.orderObj.getAll_items_in_order().clear();
                currentSubtotal.setText("");
                currentSalesTaxAmt.setText("");
                finalTotal.setText("");
                currentTotal =0;
                withSalesTax=0;
                newTotal =0;
                toast = Toast.makeText(getApplicationContext(), "Order Placed!", Toast.LENGTH_LONG);
                toast.show();

            }
        });

        currentOrder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * onItemClick method that allows the user to delete or keep the selected order when desired along with removing
             * the order object form array lists associated in other classes. This method also displays several toast messages
             * when the order is placed, removed or selected.
             * @param parent
             * @param view
             * @param position
             * @param id
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(OrderActivity.this, "Selected: " + arrayList.get(position).toString(), Toast.LENGTH_SHORT).show();
                selected = (String) currentOrder.getItemAtPosition(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(OrderActivity.this);

                builder.setIcon(android.R.drawable.ic_delete);
                builder.setCancelable((true));
                builder.setTitle("Please confirm deletion");
                builder.setMessage("Selected order will be deleted. Are you sure?");

                builder.setNegativeButton("Keep", new DialogInterface.OnClickListener() {
                    /**
                     *
                     * @param dialog
                     * @param which
                     */
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    /**
                     *
                     */
                    public void onClick(DialogInterface dialog, int which) {
                        tempSubtotal = Double.parseDouble(currentSubtotal.getText().toString());
                        for (MenuItem items : DonutOrderActivity.orderObj.getAll_items_in_order()) {
                            if (items.toString().equals(selected)) {
                                tempSubtotal -= items.getItemPrice();
                                break;
                            }
                        }

                        DonutOrderActivity.orderObj.remove(selected);
                        arrayList.remove(position);
                        adapter4.notifyDataSetChanged();

                        currentSubtotal.setText(twoDecimalPlaces(tempSubtotal));
                        currentTotal = Double.parseDouble(String.valueOf(tempSubtotal));
                        withSalesTax = SALES_TAX * currentTotal;
                        currentSalesTaxAmt.setText(twoDecimalPlaces(withSalesTax));
                        newTotal = withSalesTax + currentTotal;
                        finalTotal.setText(twoDecimalPlaces(newTotal));
                        double empty = 0.00;
                        if (arrayList.isEmpty()) {
                            currentSubtotal.setText(twoDecimalPlaces(empty));
                            currentSalesTaxAmt.setText(twoDecimalPlaces(empty));
                            finalTotal.setText(twoDecimalPlaces(empty));
                        }
                    }
                });
                builder.show();
            }
        });
    }


    }