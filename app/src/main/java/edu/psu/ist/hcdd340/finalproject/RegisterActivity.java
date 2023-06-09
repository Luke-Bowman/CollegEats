package edu.psu.ist.hcdd340.finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity  implements View.OnClickListener {

    private static final String TAG = "REGISTER_ACTIVITY";

    public static final String SHARED_PREF_NAME = "PENN_STATE_ID";
    public static final String EMAIL_KEY = "EMAIL";
    public static final String PASSWORD_KEY = "PASSWORD";
    public static final String FIRST_NAME_KEY = "FIRST_NAME";
    public static final String LAST_NAME_KEY = "LAST_NAME";


    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button registerButton = findViewById(R.id.button_register);
        registerButton.setOnClickListener(this);

        Button cancelButton = findViewById(R.id.button_cancel_registration);
        cancelButton.setOnClickListener(this);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_cancel_registration) {
            finish();
        } else if (id == R.id.button_register) {
            registerUser();
            Button button = findViewById(R.id.button_register);
            Snackbar.make(button,
                    "Registered!",
                    Snackbar.LENGTH_LONG).show();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }

    /**
     * Returns user entered text from an EditText instance
     * @param id: Id of the EditText instance
     * @return User entered text
     */
    String getInputFromEditText(int id) {
        EditText v = findViewById(id);
        return v.getText().toString();
    }

    /**
     * Registers a new user.
     * It involves two steps: 1) extract user inputs; and 2) save those values.
     */
    void registerUser() {
        String email = getInputFromEditText(R.id.editTextEmail);
        String password = getInputFromEditText(R.id.editTextPassword);
        String firstName = getInputFromEditText(R.id.editFirstName);
        String lastName = getInputFromEditText(R.id.editLastName);

        Log.d(TAG, "Email: " + email + ", first name: " + firstName +
                ", last name: " + lastName);

        saveUserInformation(email, password, firstName, lastName);
    }

    /**
     * Saves user information using SharedPreferences
     *
     */
    void saveUserInformation(String email, String password, String firstName,
                             String lastName) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(EMAIL_KEY, email);
        editor.putString(PASSWORD_KEY, password);
        editor.putString(FIRST_NAME_KEY, firstName);
        editor.putString(LAST_NAME_KEY, lastName);

        editor.apply();
    }
    @Override
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
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        else if (menuID == R.id.menu_myrecipes){
            Intent intent = new Intent(this, FoodListActivity.class);
            startActivity(intent);
            return true;
        }
        else if (menuID == R.id.menu_grocerylist) {
            Intent intent = new Intent(this, GroceryList.class);
            startActivity(intent);
            return true;
        }
        else if (menuID == R.id.menu_customlist) {
            Intent intent = new Intent(this, CustomList.class);
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