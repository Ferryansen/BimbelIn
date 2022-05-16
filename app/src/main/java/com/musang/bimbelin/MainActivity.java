package com.musang.bimbelin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnSwitchActivity;
    private int totalCover = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSwitchActivity = (ImageButton) findViewById(R.id.button_coverNext);

        SharedPreferences getTotalCover = getSharedPreferences("SAVE_FILE", Context.MODE_PRIVATE);
        totalCover = getTotalCover.getInt("TOTAL_SIMPENAN_AKSES_ACTIVITY", 0);

        if (totalCover > 0) {
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);

            finish();
        } else {
            btnSwitchActivity.setOnClickListener(view -> {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                totalCover++;

                SharedPreferences totalCoverSaved = getSharedPreferences("SAVE_FILE", Context.MODE_PRIVATE);
                SharedPreferences.Editor spEditor = totalCoverSaved.edit();
                spEditor.putInt("TOTAL_SIMPENAN_AKSES_ACTIVITY", totalCover);
                spEditor.apply();

                finish();
            });
        }

    }


}