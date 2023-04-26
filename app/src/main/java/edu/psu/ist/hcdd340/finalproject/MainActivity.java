package edu.psu.ist.hcdd340.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.snackbar.Snackbar;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuId = item.getItemId();


        if (menuId == R.id.menu_info) {
            AlertDialog.Builder d = new AlertDialog.Builder(this);
            d.setTitle(R.string.info_alert_title);
            d.setMessage(R.string.info_alert_message);
            d.setPositiveButton("OK", null);
            d.show();

        } else if (menuId == R.id.menu_register) {
            Intent registerIntent = new Intent(this, RegisterActivity.class);
            startActivity(registerIntent);
            return true;
        } else if (menuId == R.id.menu_login) {
            Intent loginIntent = new Intent(this, LoginActivity.class);
            startActivity(loginIntent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}