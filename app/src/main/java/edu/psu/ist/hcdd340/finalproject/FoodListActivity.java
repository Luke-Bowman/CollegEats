package edu.psu.ist.hcdd340.finalproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FoodListActivity extends AppCompatActivity {
    private final FoodData[] FOOD_LIST = {
            new FoodData("Shrimp Scampi", R.drawable.shrimp_scampi, "abingtonadmissions@psu.edu", "1-215-881-7600"),
            new FoodData("Cheese Burger", R.drawable.burger, "altoonaadmission@psu.edu", "1-814-949-5466"),
            new FoodData("Tacos", R.drawable.taco, "br-admissions@psu.edu", "1-724-773-3800"),
            new FoodData("Chicken Parmesan", R.drawable.chicken_parmesan, "behrend.admissions@psu.edu", "1-814-898-6100"),
            new FoodData("Shrimp Taco", R.drawable.crispy_shrimp_tacos, "behrend.admissions@psu.edu", "1-814-898-6100"),
            new FoodData("Pulled Pork", R.drawable.pulled_pork, "behrend.admissions@psu.edu", "1-814-898-6100")
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
}