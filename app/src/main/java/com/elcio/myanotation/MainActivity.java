package com.elcio.myanotation;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

/**
 * @author elcio cestari taira
 * @version 0.1
 *
 * This Class is responsible to deal with all UI
 *
 */
public class MainActivity extends AppCompatActivity {
    private SharedPreferences preferences;
    private String userMessage;
    private EditText editMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editMessage = findViewById(R.id.editMessage);

        //Set preferences to be save on user device
        preferences = getSharedPreferences(getString(R.string.shared_preferences_message), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String showMessageAlert = "";
                userMessage = editMessage.getText().toString();

                if (userMessage.equals("")) {
                    showMessageAlert = getString(R.string.wrong_input_message);
                } else {//main area of the code, in this peace of code is deal with load user message in the device.
                    showMessageAlert = getString(R.string.positve_input_message);
                    //TODO
                    //I need to implement this funcionality (save message with shared preferences)

                }
                Snackbar.make(view, showMessageAlert, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }//end's onCreate method

}//end's MainActivity class
