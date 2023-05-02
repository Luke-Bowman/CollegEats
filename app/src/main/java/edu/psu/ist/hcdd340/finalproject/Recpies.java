package edu.psu.ist.hcdd340.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Recpies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipes_from_list);


    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        int menuID = item.getItemId();

        if (menuID == R.id.menu_login) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            return true;
        }
        else if (menuID == R.id.menu_register) {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
            return true;
        }
        else if (menuID == R.id.menu_recipes){
            Intent intent = new Intent(this, FoodListActivity.class);
            startActivity(intent);
            return true;
        }
        else if (menuID == R.id.menu_myrecipes){
            Intent intent = new Intent(this, FoodProfile.class);
            startActivity(intent);
            return true;
        }
        else if (menuID == R.id.menu_grocerylist) {
            Intent intent = new Intent(this, GroceryList.class);
            startActivity(intent);
            return true;
        }
        else if  (menuID == R.id.menu_info) {
            AlertDialog.Builder d = new AlertDialog.Builder(this);
            d.setTitle(R.string.info_alert_title);
            d.setMessage(R.string.info_alert_message);
            d.setPositiveButton(android.R.string.ok, null);
            d.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
