package edu.psu.ist.hcdd340.finalproject;

class FoodData {
    final private String foodName;
    final private int profileImage;
    final private String email;
    final private String phone;

    public FoodData(String foodName, int profileImage,
                    String email, String phone) {
        this.foodName = foodName;
        this.email = email;
        this.phone = phone;
        this.profileImage = profileImage;
    }


    public String getFoodName() {
        return foodName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getProfileImage() {
        return profileImage;
    }
}
