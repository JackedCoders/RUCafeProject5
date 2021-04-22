package com.example.rucafeproject5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 *
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donutActivity = (ImageButton) findViewById(R.id.donut);
        coffeeActivity = (ImageButton) findViewById(R.id.coffee);
        storeOrderActivity = (ImageButton) findViewById(R.id.shoppingBag);
        currentOrderActivity = (ImageButton) findViewById(R.id.shoppingCart);

        donutActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openDonutActivity();
            }
        });

        coffeeActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openCoffeeActivity();
            }
        });

        storeOrderActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openStoreOrderActivity();
            }
        });

        currentOrderActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openCartActivity();
            }
        });
    }
}