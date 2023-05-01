package edu.psu.ist.hcdd340.finalproject;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.snackbar.Snackbar;

public class FoodProfile {
    private final String foodName;
    private final int foodImageID;

    FoodProfile(String foodName, int foodImageID) {
        this.foodName = foodName;
        this.foodImageID = foodImageID;
    }

    public int getFoodImageID() {
        return foodImageID;
    }

    public String getFoodName() {
        return foodName;
    }
}

