package edu.psu.ist.hcdd340.finalproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FoodListActivity extends AppCompatActivity implements View.OnClickListener{
    private final FoodData[] FOOD_LIST = {
            new FoodData("Shrimp Scampi", R.drawable.resized_shrimp_scampi),
            new FoodData("Cheese Burger", R.drawable.resized_burger),
            new FoodData("Tacos", R.drawable.resized_tacos),
            new FoodData("Chicken Parmesan", R.drawable.resized_chicken_parm),
            new FoodData("Shrimp Taco", R.drawable.resized_shrimp_tacos),
            new FoodData("Pulled Pork", R.drawable.resized_pulled_pork)
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

        Button recipeButton = findViewById(R.id.food_recipe_button);
        recipeButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View view){
        int id = view.getId();
        if (id == R.id.food_recipe_button) {
            Intent intent = new Intent(this, Recpies.class);
            startActivity(intent);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuId = item.getItemId();

        if (menuId == R.id.menu_login) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            return true;
        }
        else if (menuId == R.id.menu_register) {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
            return true;
        }
        else if (menuId == R.id.menu_recipes){
            Intent intent = new Intent(this, FoodListActivity.class);
            startActivity(intent);
            return true;
        }
        else if (menuId == R.id.menu_myrecipes){
            Intent intent = new Intent(this, FoodProfile.class);
            startActivity(intent);
            return true;
        }
        else if  (menuId == R.id.menu_info) {
            AlertDialog.Builder d = new AlertDialog.Builder(this);
            d.setTitle(R.string.info_alert_title);
            d.setMessage(R.string.info_alert_message);
            d.setPositiveButton(android.R.string.ok, null);
            d.show();
        }
        return super.onOptionsItemSelected(item);
    }
}