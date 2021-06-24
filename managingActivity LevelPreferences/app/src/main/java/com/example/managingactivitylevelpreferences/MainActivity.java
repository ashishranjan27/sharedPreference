package com.example.managingactivitylevelpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Switch mswitch;
    View parentView;
    final String COLOR_KEY = "color";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mswitch = findViewById(R.id.switch1);
        parentView = findViewById(R.id.parentLayout);

        SharedPreferences Preferences = getPreferences(MODE_PRIVATE);
        boolean isChecked = Preferences.getBoolean(COLOR_KEY,false);

        mswitch.setChecked(isChecked);

        parentView.setBackgroundColor(isChecked?Color.GREEN:Color.YELLOW);

        mswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                //note that we have not written getSharedPreferences because it is used when you are working for app and here working for activity so used this
                //means getPreferences note if you have accessed it from outside the this activity then you can not retrive it.
                SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();

                editor.putBoolean(COLOR_KEY,isChecked);
                editor.apply();
                parentView.setBackgroundColor(isChecked? Color.GREEN : Color.YELLOW);
            }
        });


    }
}