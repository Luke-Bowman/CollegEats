package edu.psu.ist.hcdd340.finalproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.imageview.ShapeableImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "COLLEGE_EATS";
    Button explorer;
    Button myRecipes;
    Button list;

    private static final int[] ACTION_ICON_IDS = {
            R.id.backIcon,
            R.id.likeIcon,
            R.id.exportIcon,
            R.id.refreshIcon
    };

    private static final FoodProfile[] FOOD_PROFILES = {
            new FoodProfile("Crispy Tacos", R.drawable.crispy_shrimp_tacos),

    };

    private static int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Set event handler for icons
         */
        for (int id : ACTION_ICON_IDS) {
            findViewById(id).setOnClickListener(this);
        }
    }


    @Override
    public void onClick(View view) {
        /*
        Handle onClick events
         */
        int id = view.getId();
        if (id == R.id.refreshIcon) {
            updateFoodProfile(moveToNextProfile());
        } else if (id == R.id.backIcon)
            updateFoodProfile(moveToPreviousProfile());
        else
            Log.d(TAG, "Unknown ID: " + id);
    }

    /**
     * Updates the screen to show the given tree
     */
    private void updateFoodProfile(FoodProfile profile) {
        showFoodProfile(profile);
    }

    /**
     * Show a given profile
     */
    private void showFoodProfile(FoodProfile foodProfile) {
        ShapeableImageView foodImage = findViewById(R.id.foodPicture);
        foodImage.setImageResource(foodProfile.getFoodImageID());

        TextView view;
        view = findViewById(R.id.foodName);
        view.setText(foodProfile.getFoodName());


    }

    /**
     * Gets next tree profile by increasing the index by 1. Also, saves the index.
     */
    private FoodProfile moveToNextProfile() {
        index = (index + 1) % FOOD_PROFILES.length;
        return FOOD_PROFILES[index];
    }

    /**
     * Gets previous tree profile by decreasing the index by 1. Also, saves the index.
     */
    private FoodProfile moveToPreviousProfile() {
        index = index - 1;
        if (index < 0)
            index = FOOD_PROFILES.length - 1;
        return FOOD_PROFILES[index];
    }


    /**
     * Gets current profile
     */
    private FoodProfile getCurrentProfile() {
        return FOOD_PROFILES[index];
    }

    /**
     * Reset profiles — move to the first profile
     */
    private FoodProfile resetProfile() {
        index = 0;
        return FOOD_PROFILES[index];
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        int menuID = item.getItemId();

        if (menuID == R.id.menu_recipes) {
            Intent intent = new Intent(this, FoodProfile.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
