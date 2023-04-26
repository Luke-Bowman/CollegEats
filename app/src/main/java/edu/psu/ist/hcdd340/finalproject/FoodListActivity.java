package edu.psu.ist.hcdd340.finalproject;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FoodListActivity extends AppCompatActivity {
    private final FoodData[] FOOD_LIST = {
            new FoodData("Shrimp Scampi", R.drawable.shrimp_scampi),
            new FoodData("Cheese Burger", R.drawable.burger),
            new FoodData("Tacos", R.drawable.taco),
            new FoodData("Chicken Parmesan", R.drawable.chicken_parmesan),
            new FoodData("Shrimp Taco", R.drawable.crispy_shrimp_tacos),
            new FoodData("Pulled Pork", R.drawable.pulled_pork)
    };

    private RecyclerView mRecyclerView;
    private FoodListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        mRecyclerView = findViewById(R.id.recycler_view_food);
        mAdapter = new FoodListAdapter(this, FOOD_LIST);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}