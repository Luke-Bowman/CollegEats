package edu.psu.ist.hcdd340.finalproject;

import android.widget.Button;

class FoodData {
    final private String foodName;
    final private int profileImage;


    public FoodData(String foodName, int profileImage) {
        this.foodName = foodName;
        this.profileImage = profileImage;
    }


    public String getFoodName() {
        return foodName;
    }



    public int getProfileImage() {
        return profileImage;
    }
}
