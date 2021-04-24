package com.example.rucafeproject5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Activity class that directly controls our activity_store.xml and has all of the functionality needed to view placed orders
 * from current order activity along with removal of selected orders when desired. This class has a few onClick methods that
 * control the behavior and functionality of the project such as removing or keeping orders along with displaying toast messages
 * @author Manveer Singh, Prasidh Sriram
 */
public class StoreActivity extends AppCompatActivity {

    private  ArrayList<String> storeList = new ArrayList<>();
    public double finalTotal, final_sales_tax, final_subtotal =0;
    private ListView storeOrders;
    private int order_num_increment = 1;

    /**
     * Method that ensures that all of the prices in coffee are only two decimal places
     * by using the String.format method
     * @param val of type double that gets passed in and converted to have two demical points
     * @return string of our parameter val to two decimal places
     */
    public String twoDecimalPlaces(double val){
        return String.format("%.02f", val);
    }

    /**
     * onCreate method that initializes our variable storeOrders to the listview associated, calculates final
     * price for placed orders along with displaying toast messages when the order has been removed.
     * Method also has dialog functionality that allows for deletion
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        storeOrders = (ListView)findViewById(R.id.storeOrderList);
        String info_all;
        for(Order order: OrderActivity.storeOrderObj.getAllOrders()){
            info_all = "Order num: " + order_num_increment++ + "\n";
            final_subtotal =0;
            for(MenuItem item: order.getAll_items_in_order()){
                item.itemPrice();
                info_all += item.toString() + "\n";
                final_subtotal += item.getItemPrice();
            }

            final_sales_tax = final_subtotal * OrderActivity.SALES_TAX;
            finalTotal = final_subtotal + final_sales_tax;
            info_all += "Total: $" + twoDecimalPlaces(finalTotal) + "[Subtotal: " + twoDecimalPlaces(final_subtotal) + ", Sales Tax: " + twoDecimalPlaces(final_sales_tax) + "] ";
            storeList.add(info_all);
        }
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1,
                    storeList);
        storeOrders.setAdapter(adapter);

        storeOrders.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * If a certain order is selected in our listview, display a dialogue box and confirm to delete the
             * specfic order
             * @param parent
             * @param view
             * @param position
             * @param id
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected_order = (String) (storeOrders.getItemAtPosition(position));
                AlertDialog.Builder builder = new AlertDialog.Builder(StoreActivity.this);

                builder.setIcon(android.R.drawable.ic_delete);
                builder.setCancelable((true));
                builder.setTitle("Confirm Order Deletion!!");
                builder.setMessage("Do you want to delete the selected order?");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    /**
                     * If clicked on delete, this method removes the order object from store orders and displays a
                     * message stating the order has been removed
                     */
                    public void onClick(DialogInterface dialog, int which) {
                        Order order_to_remove = OrderActivity.storeOrderObj.getAllOrders().get(position);
                        OrderActivity.storeOrderObj.remove(order_to_remove);
                        storeList.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton("Keep", new DialogInterface.OnClickListener() {
                    /**
                     * If clicked on keep, dialog simply exits and allows us to go with the activity as
                     * pleased
                     * @param dialog
                     * @param which
                     */
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });
    }
}