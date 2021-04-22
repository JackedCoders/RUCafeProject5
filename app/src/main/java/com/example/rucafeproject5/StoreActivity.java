package com.example.rucafeproject5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 *
 * @author Manveer Singh, Prasidh Sriram
 */
public class StoreActivity extends AppCompatActivity {

    public static ArrayList<String> storeList = new ArrayList<>();
    public static double finalTotal =0;
    private ListView storeOrders;
    private static TextInputEditText overallTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        storeOrders = (ListView)findViewById(R.id.storeOrderList);

        ArrayAdapter adapter5 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, storeList);
        storeOrders.setAdapter(adapter5);

        overallTotal = (TextInputEditText) findViewById(R.id.totalStoreOrder);
        overallTotal.setText(String.valueOf(finalTotal));
    }
}