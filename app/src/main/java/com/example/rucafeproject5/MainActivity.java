package com.example.rucafeproject5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Activity class that directly controls our activity_main.xml and has all of the functionality needed
 * to open up all the activities throughout this project (Coffee, Donut, Current Orders and Store orders
 * activities). Class contains 4 helper methods that each open their own activity and later on,
 * using onClick methods, we call these methods to open out activities
 * @author Manveer Singh, Prasidh Sriram
 */
public class MainActivity extends AppCompatActivity {

    private ImageButton donutActivity, coffeeActivity, storeOrderActivity, currentOrderActivity;

    /**
     * Helper method that gets called in onCreate method and opens our coffee activity.
     * Cleaner and easier to understand code.
     */
    public void openCoffeeActivity(){
        Intent intent = new Intent(this, CoffeeActivity.class);
        startActivity(intent);
    }

    /**
     * Helper method that gets called in onCreate method and opens our donut activity.
     * Cleaner and easier to understand code.
     */
    public void openDonutActivity(){
        Intent intent = new Intent(this, DonutActivity.class);
        startActivity(intent);
    }

    /**
     * Helper method that gets called in onCreate method and opens our current order activity.
     * Cleaner and easier to understand code.
     */
    public void openCartActivity(){
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
    }

    /**
     * Helper method that gets called in onCreate method and opens our store order activity.
     * Cleaner and easier to understand code.
     */
    public void openStoreOrderActivity(){
        Intent intent = new Intent(this, StoreActivity.class);
        startActivity(intent);
    }

    /**
     * Void method that initializes our private instance variables (donutActivity, coffeeActivity,
     * storeOrderActivity, currentOrderActivity) to their respective image buttons and based on which one
     * is clicked, opens activities using the helper methods above
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donutActivity = (ImageButton) findViewById(R.id.donut);
        coffeeActivity = (ImageButton) findViewById(R.id.coffee);
        storeOrderActivity = (ImageButton) findViewById(R.id.shoppingBag);
        currentOrderActivity = (ImageButton) findViewById(R.id.shoppingCart);

        /**
         * If donut image button is clicked, call its helper method and open the activity
         */
        donutActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openDonutActivity();
            }
        });

        /**
         * If coffee image button is clicked, call its helper method and open the activity
         */
        coffeeActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openCoffeeActivity();
            }
        });

        /**
         * If store order image button is clicked, call its helper method and open the activity
         */
        storeOrderActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openStoreOrderActivity();
            }
        });

        /**
         * If current order image button is clicked, call its helper method and open the activity
         */
        currentOrderActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openCartActivity();
            }
        });
    }
}